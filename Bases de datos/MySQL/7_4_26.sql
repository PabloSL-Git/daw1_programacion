-- alguien intenta hacer venta de stock y si no hay que so se haga, hacer con trigger

DELIMITER $$

CREATE TRIGGER venta
BEFORE UPDATE ON pedidos
FOR EACH ROW
BEGIN
    -- Obtener el stock del producto
    SELECT stock --  INTO stock_actual
    FROM productos
    where codproducto = 


END $$

DELIMITER ;