/* 1. Procedimiento para obtener listado de todos los centros */
delimiter $$
create procedure buscaCentros()
begin
	select centros.numce as 'Num', 
		centros.nomce as 'Nombre'
	from centros
	order by centros.nomce;

end $$
delimiter ;

call buscaCentros();

/**** 2. Consulta de datos de un centro */

select numce, dirce, nomce, codpostal
from centros
-- where numce = celdaCentrosDeFilaActual;
where numce = 20;


delimiter $$
drop procedure if exists BuscaUnCentro $$
create procedure BuscaUnCentro
	(in numCentro int
     )
begin
    select numce as num, dirce as direccion, nomce as nombre, codpostal as codigoPos
	from centros
	-- where numce = celdaCentrosDeFilaActual;
	where numce = numCentro;

end $$
delimiter ;
/* el programador de java (u otro lenguaje):
call BuscaUnCentro(celdaCentrosDeFilaActual);
*/
-- nosotros para probar el procedimeinto:
call BuscaUnCentro(20);

/*** 3. Insertar un nuevo centro ***/

set @nuevocentro = (select max(numce)+1 from centros);
insert into centros
	(numce, nomce, dirce,codpostal)
values
	(@nuevocentro, centros.getnombre,centros.getdircentro, centros.getcodpostal); 


delimiter $$
drop procedure if exists insertaCentros $$
create procedure insertaCentros
	(in nombre varchar(60),
     in direccion varchar(60),
     in codigopostal char(5),
     out resultado int
     )
begin
	declare nuevocentro int;
	
    start transaction;
    
		set nuevocentro = (select max(numce)+10 
						   from centros);
		
		insert into centros
			(numce, nomce, dirce,codpostal)
		values
			(nuevocentro, 
			nombre,
			direccion,
			codigopostal);
	commit;
    set resultado = nuevocentro;

end $$
delimiter ;
/* el programador de java (u otro lenguaje):
call insertaCentros(centro.getnombre,
	centro.getdireccion, centro.codpostal, miResultado);
*/
-- nosotros para probar el procedimeinto:
call insertaCentros('probando','sin calle', '29680', @result);

select @result;

/*****  EDICION DE CENTRO DE TRABAJO **/
/** 4. Modificación de datos de un centro (UPDATE) */
delimiter $$
drop procedure if exists ActualizaCentro $$
create procedure ActualizaCentro 
	(in numCentro int,
     in nombre varchar(60),
     in direccion varchar(60),
     in codigopostal char(5)
     )
begin
    update centros
    set 
		nomce = nombre,
        dirce = direccion,
        codpostal = codigopostal
	where numce = numCentro;

end $$
delimiter ;
/* el programador de java (u otro lenguaje):
call ActualizaCentro(centro.getnumcentro, .....);
*/
-- nosotros para probar el procedimeinto:
set @nombre = 'nombre nuevo';

call ActualizaCentro(40, @nombre,'dir nueva','29605');
call BuscaUnCentro(40); -- nosotros consultamos que los datos del centro se han actualizado


/*** 5. Eliminar un centro (DELETE) */

delimiter $$
drop procedure if exists BorraCentro $$
create procedure BorraCentro 
	(in numCentro int
     )
begin
    -- PARA CUMPLIR CON LA RESTRICCIÓN DE INTEGRIDAD REFERENCIAL ENTRE CENTROS Y DEPTOS
    -- (YA QUE LA FK DE DEPTOS CON CENTROS ESTÁ DEFINIDA COMO  ON DELETE NO ACTION)
    -- SOLO PERMITIMOS QUE SE BORRE EL CENTRO SI NO HAY DEPARTAMENTOS DE ESE CENTRO:
    if not exists(select * from departamentos where numce = numCentro) then
        delete from centros
	    where numce = numCentro;

end $$
delimiter ;
/* el programador de java (u otro lenguaje):
call BorraCentro(centro.getnumcentro);
*/
-- nosotros para probar el procedimeinto:
call BorraCentro(41);

