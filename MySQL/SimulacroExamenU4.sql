-- 1
INSERT INTO reservas (codreserva, codcliente, codcasa, fecreserva, fecinestancia, numdiasestancia, pagoacuenta)
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
Respuesta 1: Consultar las casas de una zona

Sin aislamiento:
Si el proceso principal se ejecuta sin transacciones, el usuario puede consultar viviendas mientras estas están siendo insertadas o modificadas. Como resultado, puede obtener datos incompletos o inconsistentes, produciéndose lecturas sucias.

Con aislamiento:
Si el proceso se ejecuta de forma aislada, el usuario solo podrá consultar las viviendas que ya estén confirmadas en la base de datos. Las nuevas viviendas no serán visibles hasta que finalice la transacción, evitando inconsistencias.

Respuesta 2: Añadir una casa nueva

Sin aislamiento:
El usuario puede intentar insertar una nueva vivienda al mismo tiempo que el proceso principal está insertando otras viviendas. Esto puede provocar conflictos de escritura, duplicación de claves o pérdida de integridad referencial.

Con aislamiento:
La inserción de la nueva vivienda quedará bloqueada o se rechazará hasta que finalice la transacción principal. De esta forma se garantiza la consistencia y se evitan errores de concurrencia.

Respuesta 3: Añadir una reserva de una vivienda existente

Sin aislamiento:
El usuario puede añadir la reserva mientras el proceso principal se está ejecutando. Aunque la vivienda ya existía previamente, existe riesgo de inconsistencias si se están modificando datos relacionados.

Con aislamiento:
La operación se permite sin problemas, ya que la vivienda ya estaba registrada antes de iniciar el proceso principal y no se ve afectada por la incorporación de la base de datos de la otra empresa.
*/