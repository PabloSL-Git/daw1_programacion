-- 1. Listado de asistentes a la fiesta (clientes + propietarios sin duplicados)
SELECT nompropietario AS nombre, tlf_contacto, correoelectronico
FROM propietarios
UNION
SELECT CONCAT(nomcli, ' ', ape1cli, ' ', ape2cli), tlf_contacto, correoelectronico
FROM clientes;

-- 2. Casas con número de reservas (incluyendo las que nunca se han reservado), ordenadas de más a menos
SELECT casas.nomcasa, zonas.nomzona, COUNT(reservas.codreserva) AS num_reservas
FROM casas
LEFT JOIN zonas ON casas.codzona = zonas.numzona
LEFT JOIN reservas ON casas.codcasa = reservas.codcasa
GROUP BY casas.codcasa, casas.nomcasa, zonas.nomzona
ORDER BY num_reservas DESC;

-- 3. Lo mismo pero sin reservas anuladas
SELECT casas.nomcasa, zonas.nomzona, COUNT(reservas.codreserva) AS num_reservas
FROM casas
LEFT JOIN zonas ON casas.codzona = zonas.numzona
LEFT JOIN reservas ON casas.codcasa = reservas.codcasa AND reservas.fecanulacion IS NULL
GROUP BY casas.codcasa, casas.nomcasa, zonas.nomzona
ORDER BY num_reservas DESC;

-- 4. Reservas no anuladas en un periodo dado
SELECT casas.nomcasa, zonas.nomzona, COUNT(reservas.codreserva) AS num_reservas
FROM casas
LEFT JOIN zonas ON casas.codzona = zonas.numzona
LEFT JOIN reservas 
    ON casas.codcasa = reservas.codcasa 
    AND reservas.fecanulacion IS NULL
    AND reservas.feciniestancia >= '2012-01-01' 
    AND reservas.feciniestancia <= '2013-12-31'
GROUP BY casas.codcasa, casas.nomcasa, zonas.nomzona
ORDER BY num_reservas DESC;

-- 5. Casas disponibles en un periodo dado
SELECT casas.codcasa, casas.nomcasa, zonas.nomzona
FROM casas
LEFT JOIN zonas ON casas.codzona = zonas.numzona
WHERE casas.codcasa NOT IN (
    SELECT codcasa
    FROM reservas
    WHERE fecanulacion IS NULL
      AND feciniestancia <= '2013-12-31'
      AND DATE_ADD(feciniestancia, INTERVAL numdiasestancia DAY) >= '2013-01-01'
);

-- 6. Convertir la consulta anterior en una VIEW
CREATE VIEW casas_disponibles AS
SELECT casas.codcasa, casas.nomcasa, zonas.nomzona
FROM casas
LEFT JOIN zonas ON casas.codzona = zonas.numzona
WHERE casas.codcasa NOT IN (
    SELECT codcasa
    FROM reservas
    WHERE fecanulacion IS NULL
      AND feciniestancia <= '2013-12-31'
      AND DATE_ADD(feciniestancia, INTERVAL numdiasestancia DAY) >= '2013-01-01'
);

-- 7. Lógica del precio a día de hoy
CREATE VIEW precio_actual AS
SELECT 
    articulos.refart,
    articulos.nomart,
    categorias.nomcat,
    COALESCE(catalogospromos.precioartpromo, articulos.precioventa) AS precio_hoy
FROM articulos
JOIN categorias ON articulos.codcat = categorias.codcat
LEFT JOIN catalogospromos ON articulos.refart = catalogospromos.refart
LEFT JOIN promociones 
    ON catalogospromos.codpromoprecio_actual = promociones.codpromo
    AND CURDATE() BETWEEN promociones.fecinipromo 
        AND DATE_ADD(promociones.fecinipromo, INTERVAL promociones.duracionpromo DAY)
WHERE catalogospromos.codpromo IS NULL OR promociones.codpromo IS NOT NULL;

SELECT * FROM precio_actual;

/* ACTIVIDADES FUNCIONES 5 */

-- 1