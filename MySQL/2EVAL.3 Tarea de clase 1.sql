-- Nos piden que para la BD empresaclase y dado el número de empleado (numem), 
-- preparemos una rutina con la que podamos obtener la dirección en la que trabaja dicho empleado.
-- Diseña las siguientes rutinas:

-- a) Al llamarla (call), muestre la dirección del empleado.
delimiter $$
drop procedure if exists TareaDeClase1a
$$
create procedure TareaDeClase1a(in numeroEmpleado int (60))
begin

SELECT dirce
FROM centros JOIN departamentos
	USING (numce)
JOIN empleados
	USING (numde)
where numem = numeroEmpleado;

end
$$
delimiter ;
call TareaDeClase1a (190);

-- b) Al llamarla (call), devuelva la dirección del empleado.
delimiter $$
drop procedure if exists TareaDeClase1b
$$
create procedure TareaDeClase1b(in numeroEmpleado int (60), OUT direccion VARCHAR(60))
begin

SELECT dirce into direccion
FROM centros JOIN departamentos
	USING (numce)
JOIN empleados
	USING (numde)
where numem = numeroEmpleado;

end
$$
call TareaDeClase1b (190, @direccion);
select @direccion;
delimiter ;

-- c) Al ejecutarla devuelva la dirección del empleado.

delimiter $$
drop function if exists TareaDeClase1c
$$
create function TareaDeClase1c(numeroEmpleado int (60))
returns VARCHAR(60)
deterministic
begin
declare direccion varchar(60);

SELECT dirce into direccion
FROM centros JOIN departamentos
	USING (numce)
JOIN empleados
	USING (numde)
where numem = numeroEmpleado;
return direccion;
end
$$
delimiter ;
select TareaDeClase1c (190) as numeroEmpleado;