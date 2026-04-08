-- Programas de CRUD para la basa de datos GBDturRural2015

-- Zona
/* 1. Procedimiento para obtener listado de todos las zonas */
delimiter $$
create procedure buscaZonas()
begin
	select zonas.numzona as 'Numero', 
		zonas.nomzona as 'Nombre'
	from zonas
	order by zonas.numzona;

end $$
delimiter ;

call buscaZonas();

/* 2. Consulta de datos de una zona */

select numzona, nomzona, deszona
from centros

delimiter $$
drop procedure if exists BuscaUnaZona $$
create procedure BuscaUnaZona(in numero int)

begin
    select numzona as numero, nomzona as nombre, deszona as descripcion
	from zonas
	where  numzona = numero;

end $$
delimiter ;

call BuscaUnaZona(5);

/*** 3. Insertar una nueva zona ***/

set @nuevazona = (select max(numzona)+1 from zonas);
insert into zonas
	(numzona, nomzona , deszona)
values
	(@nuevazona, zonas.nomzona, zonas.deszona); 


delimiter $$
drop procedure if exists insertaZonas $$
create procedure insertaZonas(in nombre varchar(60), in descripcion varchar(60))

begin
	declare nuevocentro int;
	
    start transaction;
    
		set nuevazona = (select max(numzona)+1
						   from zonas);
		
		insert into zonas
			(numzona, nomzona, deszona)
		values
			(nuevazona, 
			nombre,
			descripcion);
	commit;
    set resultado = nuevazona;

end $$
delimiter ;

call insertaCentros('aloja','sin shoesssss');

select @result;