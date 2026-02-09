-- 1
INSERT INTO reservas (codreserva, codcliente, codcasa, fecreserva, feciniestancia, numdiasestancia, pagocuenta)
VALUES (3501, 520, 315, CURDATE(), '2026-08-05', 7, 100);

-- 2
INSERT INTO caracteristicasdecasas (codcasa, codcaracter, tiene, observaciones)
VALUES
(350, 17, 1, 'Nueva barbacoa'),
(350, 3, 1, 'A/A añadido'),
(350, 5, 1, 'Calefacción añadida');

-- 3
-- Marcar reserva como anulada
UPDATE reservas
SET fecanulacion = CURDATE()
WHERE codreserva = 2450;

-- Registrar devolución
INSERT INTO devoluciones (numdevol, codreserva, importedevol)
VALUES (
    (SELECT COALESCE(MAX(numdevol), 0) + 1 FROM devoluciones),
    2450,
    200
);

-- 4

DELIMITER $$

CREATE PROCEDURE BajaPropietario(IN p_codprop INT)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
        START TRANSACTION;
    -- Borrar devoluciones
    DELETE d
    FROM devoluciones d
    JOIN reservas r ON d.codreserva = r.codreserva
    JOIN casas c ON r.codcasa = c.codcasa
    WHERE c.codpropi = p_codprop;

    -- Borrar reservas
    DELETE r
    FROM reservas r
    JOIN casas c ON r.codcasa = c.codcasa
    WHERE c.codpropi = p_codprop;

    -- Borrar casas
    DELETE FROM casas WHERE codpropi = p_codprop;

    -- Borrar propietario
    DELETE FROM propietarios WHERE codpropietario = p_codprop;

    COMMIT;
END $$

DELIMITER ;

-- 5
UPDATE casas
SET numhabit = 3, m2 = 200, minpersonas = 4, maxpersonas = 8
WHERE codcasa = 5789;

-- 6

DELIMITER $$

CREATE PROCEDURE IncorporarDatosOtraEmpresa()
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO propietarios (codpropietario, nompropietario, personaContacto, dni_cif, tlf_contacto, correoElectronico)
    SELECT codprop, nomprop, ape1prop, dni_cif, tlf_contacto, correoElectronico
    FROM GBDDatosViviendasYPropiOrigen.propietarios;

    INSERT INTO casas (codcasa, nomcasa, numbanios, numhabit, m2, minpersonas, maxpersonas, preciobase, codpropi, codtipocasa, codzona)
    SELECT codViv, nomViv, numbanios, numhabit, m2, minpersonas, maxpersonas, preciobase, codpropi, codtipocasa, codzona
    FROM GBDDatosViviendasYPropiOrigen.viviendas;

    COMMIT;
END $$

DELIMITER ;


-- 7
/*
1. Consultar las casas de una zona

Sin aislamiento:
El usuario puede consultar las casas mientras el proceso de incorporación está insertando datos.
Esto puede provocar que se obtengan resultados incompletos o inconsistentes,
ya que podrían mostrarse casas que aún no forman parte definitivamente de la base de datos (lecturas sucias).

Con aislamiento:
El usuario solo podrá consultar las casas que ya estaban confirmadas antes del inicio de la transacción.
Las nuevas casas no serán visibles hasta que el proceso finalice con COMMIT, evitando lecturas inconsistentes.

🔹 2. Añadir una casa nueva

Sin aislamiento:
El usuario puede insertar una nueva casa de forma concurrente al proceso principal. Esto puede provocar conflictos, 
como colisiones de claves primarias o problemas de integridad referencial si ambos procesos acceden a las mismas tablas simultáneamente.

Con aislamiento:
La inserción de la nueva casa puede quedar bloqueada hasta que finalice la transacción principal.
De esta forma se garantiza la consistencia de los datos y se evita que se produzcan conflictos durante el proceso de incorporación.

🔹 3. Añadir una reserva de una casa existente

Sin aislamiento:
El usuario puede añadir la reserva mientras el proceso principal se está ejecutando. Aunque la casa ya existía previamente,
pueden producirse inconsistencias si el proceso principal modifica o bloquea datos relacionados.

Con aislamiento:
La operación puede quedar temporalmente bloqueada mientras se ejecuta la transacción principal,
dependiendo del nivel de aislamiento utilizado. No obstante, una vez finalizada la transacción, la reserva podrá realizarse sin inconsistencias, garantizando la integridad de la base de datos.
*/