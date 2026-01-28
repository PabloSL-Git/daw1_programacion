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
where fecanulacion >= 2006/1/1 and numdevol > 0;

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
	select nomcaracter
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




