-- 1
INSERT INTO reservas (codreserva, codcliente, codcasa, fecreserva, fecinestancia, numdiasestancia, pagoacuenta)
VALUES (
    (SELECT MAX(codreserva) + 1 FROM reservas),  -- genera nuevo código
    520,
    315,
    CURDATE(),               -- fecha de hoy
    '2026-08-05',           -- inicio de estancia
    7,
    100
);

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
    DECLARE cant_reservas INT;

    START TRANSACTION;

    -- Comprobar si el propietario tiene casas con reservas activas
    SELECT COUNT(*) INTO cant_reservas
    FROM casas c
    JOIN reservas r ON c.codcasa = r.codcasa
    WHERE c.codpropi = p_codprop AND r.fecanulacion IS NULL;

    IF cant_reservas > 0 THEN
        -- No se puede eliminar, hay reservas activas
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede eliminar propietario con reservas activas';
        ROLLBACK;
    ELSE
        -- Borrar reservas canceladas y devoluciones si existen
        DELETE r
        FROM reservas r
        JOIN casas c ON r.codcasa = c.codcasa
        WHERE c.codpropi = p_codprop;

        DELETE d
        FROM devoluciones d
        JOIN reservas r ON d.codreserva = r.codreserva
        JOIN casas c ON r.codcasa = c.codcasa
        WHERE c.codpropi = p_codprop;

        -- Borrar casas
        DELETE FROM casas WHERE codpropi = p_codprop;

        -- Borrar propietario
        DELETE FROM propietarios WHERE codproprietario = p_codprop;

        COMMIT;
    END IF;
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
    START TRANSACTION;

    -- Insertar propietarios
    INSERT INTO propietarios (codpropietario, nompropietario, personaContacto, dni_cif, tlf_contacto, correoElectronico)
    SELECT codprop, nomprop, ape1prop, dni_cif, tlf_contacto, correoElectronico
    FROM GBDDatosViviendasYPropiOrigen.propietarios;

    -- Insertar casas
    INSERT INTO casas (codcasa, nomcasa, numbanios, numhabit, m2, minpersonas, maxpersonas, preciobase, codpropi, codtipocasa, codzona)
    SELECT codViv, nomViv, numbanios, numhabit, m2, minpersonas, maxpersonas, preciobase, codpropi, codtipocasa, codzona
    FROM GBDDatosViviendasYPropiOrigen.viviendas;

    COMMIT;
END $$
DELIMITER ;

-- 7
-- Otro usuario intenta consultar casas de una zona
SELECT * 
FROM casas
WHERE codzona = 3;
-- Dependiendo del nivel de aislamiento:
-- READ UNCOMMITTED → verá casas a medio insertar
-- READ COMMITTED → solo verá casas confirmadas
-- SERIALIZABLE → puede quedar bloqueado hasta que COMMIT termine

-- Otro usuario intenta añadir una casa nueva
INSERT INTO casas (codcasa, nomcasa, numbanios, numhabit, m2, minpersonas, maxpersonas, preciobase, codpropi, codtipocasa, codzona)
VALUES (9999, 'Casa Prueba', 2, 3, 120, 2, 6, 100, 1, 1, 3);
-- Dependiendo del bloqueo que aplique la transacción, este INSERT puede:
-- - Esperar hasta que se haga COMMIT
-- - O fallar si la tabla está bloqueada

-- Otro usuario intenta añadir una reserva para una casa que está siendo incorporada
INSERT INTO reservas (codreserva, codcliente, codcasa, fecreserva, fecinestancia, numdiasestancia, pagoacuenta)
VALUES ((SELECT MAX(codreserva)+1 FROM reservas), 100, 5640, CURDATE(), '2026-08-10', 7, 200);
-- Si la casa 5640 aún no se ha insertado en la BD principal, este INSERT puede fallar por FK

