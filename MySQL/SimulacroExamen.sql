-- P1 Prepara una consulta que muestre, de la forma más eficientemente posible,
--  todos los datos de las reservas hechas en el primer trimestre de este año (entre 1/1/2021 y
-- el 30 de marzo de 2021) de más de 3 días de duración de la estancia. 
select *
from reservas
where fecreserva >= '2021/1/1' and  fecreserva <= '2021/3/30' and numdiasestancia > 3;

-- P2 Prepara una consulta que muestre las reservas que se han anulado este año 
-- y el importe de la devolución (si se ha producido). Nos interesa mostrar el código de la reserva y el nombre
-- y apellidos del cliente (en una sola columna).

select reservas.codreserva as reserva, concat_ws(" ", nomcli, ape1cli, ape2cli) as nombre, importedevol
from clientes join reservas
on clientes.codcli = reservas.codcliente
join devoluciones
on reservas.codreserva = devoluciones.codreserva
where fecanulacion >= '2006/1/1' and numdevol > 0;

-- P3 Prepara una rutina que, dado un código de característica, muestre el código, nombre,
-- población y tipo de casa (nombre del tipo) de las casas que tienen esa característica.
-- Muestra los resultados ordenados por la población y para una misma población,
-- primero las que tengan más metros cuadrados. 

delimiter $$
drop procedure if exists simulacroP3
$$
create procedure simulacroP3(codigoCasa int(30))
deterministic
begin
	select poblacion , nomcasa, codtipocasa, m2, codigoCasa
    from caracteristicas join caracteristicasdecasas
    on caracteristicas.numcaracter = caracteristicasdecasas.codcasa
    join casas
    on caracteristicasdecasas.codcasa = casas.codcasa
    where codigoCasa = numcaracter
	order by casas.m2 desc; 
end $$
delimiter ;
call simulacroP3(3);

-- P4 Prepara una rutina que, dado un código de casa, muestre el listado de características
-- (nombre de característica) que tiene esa casa 
-- (ten en cuenta que el campo tiene de caracteristicasdecasas tendrá que ser 1)

delimiter $$
drop procedure if exists simulacroP4;
$$
create procedure simulacroP4(codigoCasa int(30))
deterministic
begin	
	select nomcaracter as caracteristica
    from caracteristicas
    where numcaracter = codigoCasa;

end $$
delimiter ;
call simulacroP4(3);

-- P5 Prepara una rutina para ver el número de características de cada casa.

delimiter $$
drop procedure if exists simulacroP5;
$$
create procedure simulacroP5(nombreCasa varchar (80))
deterministic
begin
	select nombreCasa, numcaracter as numeroCaracteristicas
    from casas join caracteristicasdecasas
    using(codcasa)
    join caracteristicas
    on caracteristicasdecasas.codcaracter = caracteristicas.numcaracter
    where nomcasa = nombreCasa;
end $$
delimiter ;
call simulacroP5("jazmin");


-- P6 Si el preciobase de la casa es el precio del alquiler de cada día,
-- prepara una rutina que permita ver el valor medio de lo que ha costado
-- cada reserva (ten en cuenta que tenemos el número de días de cada estancia en las reservas).
-- ¿Y si fuera solo de las reservas no anuladas?

delimiter $$
drop procedure if exists simulacroP6;
$$
create procedure simulacroP6( codreserva int (10))
deterministic
begin 
	select codreserva, preciobase, numdiasestancia, preciobase * numdiasestancia as calculoPrecio, numdevol
    from casas join reservas
    using(codcasa)
    join devoluciones
    using(codreserva)
    where numdevol is null;
end $$
delimiter ;
call simulacroP6(4);

-- P7 Prepara una rutina que, dado el código de una reserva, devuelva:
-- El nombre del propietario de la casa que se ha reservado 
-- y el teléfono y correo juntos separados por ‘//’.

delimiter $$
drop procedure if exists simulacroP7;
$$
create procedure simulacroP7(codigoReserva int (19), out nombre varchar (100), out telefono_correo varchar(60))
deterministic
begin
	SELECT nompropietario, concat(tlf_contacto, ' // ', correoelectronico) into nombre, telefono_correo
	from reservas join casas
    using(codcasa)
    join propietarios
    on casas.codpropi = propietarios.codpropietario
where reservas.codreserva = codigoReserva;
end $$
delimiter ;
call simulacroP7(1, @nombre, @telefono_correo);
select @nombre, @telefono_correo;

-- P8 Prepara una rutina que muestre el número de reservas que se han 
-- hecho este año en cada zona (usa la fecha de la reserva y la funcion year donde: 
-- year(miFecha): miFecha es un date ⇒ la función year devuelve un valor entero (el año de miFecha)

-- version procedure
DELIMITER $$
DROP PROCEDURE IF EXISTS simulacroP8a;
$$
CREATE PROCEDURE simulacroP8(fechaUsuario DATE)
BEGIN
    SELECT *
    FROM reservas
    WHERE YEAR(fecreserva) = YEAR(fechaUsuario);
END
$$
DELIMITER ;
CALL simulacroP8('2012-04-02');

-- version function
delimiter $$
drop function if exists simulacroP8b;
$$
create function simulacroP8b(fechaUsuario date)
returns int(30)
deterministic
begin
	declare reserva int(30);
    
	select COUNT(*) into reserva
    from reservas
    WHERE YEAR(reservas.fecreserva) = YEAR(fechaUsuario);
return reserva;
end $$
delimiter ;
select simulacroP8b('2012-04-02');

-- P9 Prepara una rutina que, dado un código de zona,
-- muestre el número de reservas que se han hecho este año en dicha zona.

delimiter $$
drop procedure if exists simulacroP9;
$$
create procedure simulacroP9 (codzona int(20))
begin
	select reservas.codreserva as reservas
    from casas join reservas
    using(codcasa)
    where year(reservas.fecreserva) = YEAR(CURDATE());
end $$
delimiter ;
call simulacroP9(1);

-- P10 Queremos saber cual es la media de los metros cuadrados que tienen las casas de nuestra aplicación,
-- el máximo número de baños y de habitaciones.

SELECT 
    AVG(m2) AS mediaMetrosCuadrados,
    MAX(numbanios) AS maxBaños,
    MAX(numhabit) AS maxHabitaciones
FROM casas;

/* 
FUNCIONES DE AGREGACIÓN (EXAMEN)

Sirven para resumir varias filas en un solo resultado.

FUNCIONES IMPORTANTES:
- COUNT(*)     -> Cuenta todas las filas
- COUNT(campo) -> Cuenta filas NO NULL
- SUM(campo)   -> Suma valores
- AVG(campo)   -> Media (ignora NULL)
- MAX(campo)   -> Valor máximo
- MIN(campo)   -> Valor mínimo


- AVG y SUM ignoran valores NULL
- COUNT(*) cuenta incluso filas con NULL
- COUNT(campo) NO cuenta NULL
- MAX y MIN funcionan aunque haya NULL
- Se suelen usar con GROUP BY
*/



