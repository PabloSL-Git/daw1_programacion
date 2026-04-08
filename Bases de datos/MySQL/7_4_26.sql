-- alguien intenta hacer venta de stock y si no hay que so se haga, hacer con trigger

DELIMITER $$

CREATE TRIGGER venta
BEFORE UPDATE ON pedidos
FOR EACH ROW
BEGIN
	DECLARE stock_actual INT;

    -- Obtener el stock actual
    SELECT stock into stock_actual
    FROM articulos
    WHERE refart = NEW.refart;

    -- Verificar si hay suficiente stock
    IF stock < NEW.cantidad THEN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No hay suficiente stock para realizar la venta';
    END IF;

END$$

DELIMITER ;