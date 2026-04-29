-- EJEMPLO TRIGGER
-- “En una empresa de ventas, no se puede vender un producto si no hay stock suficiente.
-- Además, cuando se realice una venta, se debe descontar automáticamente del stock.
-- Y si el stock baja de 5 unidades, se debe generar un pedido automático.”

-- 1 TRIGGER --> CONTROL (BEFORE INSERT)
delimiter $$
CREATE TRIGGER comprobar_stock
BEFORE INSERT ON detalleventa
FOR EACH ROW
BEGIN
   DECLARE stock_actual int;

   SELECT stock INTO stock_actual
   FROM producto
   WHERE id = NEW.idproducto;

   IF NEW.cantidad > stock_actual THEN
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Stock insuficiente';
   END IF;
END $$
delimiter ;

-- 2 TRIGGER --> Acción (AFTER INSERT)
delimiter $$
CREATE TRIGGER actualizar_stock
AFTER INSERT ON detalleventa
FOR EACH ROW
BEGIN
   UPDATE producto
   SET stock = stock - NEW.cantidad
   WHERE id = NEW.idproducto;
END $$
delimiter ;

-- 3 TRIGGER --> Acción extra (AFTER)
delimiter $$
CREATE TRIGGER pedido_automatico
AFTER UPDATE ON producto
FOR EACH ROW
BEGIN
   IF NEW.stock < 5 THEN
      INSERT INTO pedido (idproducto, fecha)
      VALUES (NEW.id, NOW());
   END IF;
END $$
delimiter ;

-- EJEMPLO EVENTOS
-- Cada mes, la empresa debe generar automáticamente los recibos de los clientes.
CREATE EVENT generar_recibos
ON SCHEDULE
   EVERY 1 MONTH
   STARTS '2026-05-01'
   ENDS '2027-05-01'
DO
   CALL crearRecibosMes();

-- 🔹 IMPORTANTE
-- Si no funciona:
-- SET GLOBAL event_scheduler = ON;

-- EJEMPLO ÍNDICES
-- Tengo una tabla con 1 millón de clientes y busco por NIF.

-- SIN Índice: SELECT * FROM cliente WHERE nif = '12345678A';
-- CON Índice: CREATE INDEX idx_nif ON cliente(nif);

-- Tipos importantes:
-- UNIQUE
CREATE UNIQUE INDEX idx_nif ON cliente(nif);

-- MULTICOLUMNA
CREATE INDEX idx_nombre_apellido ON cliente(nombre, apellido);

-- Right y Left join


-- BDTurismoRural
-- Listado de nombre las casas y el número de reservas que se han
-- hecho y no estén anuladas
select nomcasa, count(codreserva) as númeroReservas
from casas left join reservas
using (codcasa)
where fecanulacion is null
group by nomcasa;

show index from empleados;

select *
from empleados ignore index(nombresEmpleados)
where nomem = 'eva';

/*
📅 FUNCIONES DE FECHA Y TIEMPO
CURDATE()              -- fecha actual
CURTIME()              -- hora actual
NOW()                  -- fecha y hora actual
YEAR(fecha)            -- año de una fecha
MONTH(fecha)           -- mes
DAY(fecha)             -- día
DAYNAME(fecha)         -- nombre del día
MONTHNAME(fecha)       -- nombre del mes
DATEDIFF(f1,f2)        -- diferencia en días
DATE_ADD(f, INTERVAL 7 DAY)   -- sumar días
DATE_SUB(f, INTERVAL 1 MONTH) -- restar meses

🔢 FUNCIONES MATEMÁTICAS
ABS(x)                 -- valor absoluto
ROUND(x,2)             -- redondear
CEIL(x)                -- hacia arriba
FLOOR(x)               -- hacia abajo
MOD(a,b)               -- resto
POWER(a,b)             -- potencia
SQRT(x)                -- raíz cuadrada

🔤 FUNCIONES DE TEXTO
UPPER(txt)             -- mayúsculas
LOWER(txt)             -- minúsculas
CONCAT(a,b)            -- unir textos
LENGTH(txt)            -- longitud
SUBSTRING(txt,1,3)     -- cortar texto
TRIM(txt)              -- quitar espacios

🔍 FUNCIONES DE CONTROL
IF(cond,a,b)           -- si cumple → a, si no → b
IFNULL(x,0)            -- reemplaza NULL
CASE WHEN c THEN a ELSE b END -- múltiples condiciones

🧮 FUNCIONES DE AGREGACIÓN
COUNT(*)               -- contar filas
SUM(col)               -- suma
AVG(col)               -- media
MAX(col)               -- máximo
MIN(col)               -- mínimo

⚡ TRIGGERS (CLAVE)
NEW.columna            -- valor nuevo (INSERT/UPDATE)
OLD.columna            -- valor antiguo (DELETE/UPDATE)
NOW()                  -- timestamp automático
CURDATE()              -- fecha en triggers
USER()                 -- usuario actual
*/