-- TEORIA
-- obtener -> procedimiento

-- devuelva -> 1 dato -> funcion
--          -> varios datos -> procedimiento con parametro de salida	

-- drop procedure if exist ____

-- PRACTICA CLASE
-- direccion de trabajo del empleado a travez del numero del trabajador
SELECT dirce
FROM centros JOIN departamentos
	USING (numce)
JOIN dirigir
	ON departamentos.numde = dirigir.numdepto
JOIN empleados
	ON empleados.numem = dirigir.numempdirec
;

-- Obtener el nombre y el presupuesto de los departamentos que están ubicados en la “SEDE CENTRAL”. (Los dos procedimientos)
-- en procedimiento
delimiter $$;
create procedure apartado5practicaA(in nombreCentro varchar (20))
begin

select numde, presude, nomce
from  departamentos join centros
	using (numce)
where nomce = nombreCentro
order by numde desc;

end
$$;

-- en procedimiento con parametros de salida
delimiter $$;
create procedure apartado5practicaB(out nombreDepto varchar (60), in nombreCentro varchar(60), out presupuestoDepto decimal(10,2))
begin

select departamentos.nomde, departamentos.presude into nombreDepto, presupuestoDepto
from  departamentos join centros
	using (numce)
where trim(centros.nomce) = trim(nombreCentro)
order by nomde desc
limit 1;

end
$$;

-- devuelve el presupuesto y el nombre del centro de un departamento dado (su nombre)

-- EJEMPLOS
-- departamanetos malaga
select departamentos.nomde, codpostal
from departamentos join centros
	on departamentos.numce = centros.numce -- using(numce)
where left (centros.codpostal,2) = '28'
order by departamentos.nomde asc;

-- nombre director de cada centro
SELECT concat_ws(' ', nomem, ape1em, ape2em) as nombreCompleto,
nomde,numem,numempdirec
FROM centros JOIN departamentos
	USING (numce)
JOIN dirigir
	ON departamentos.numde = dirigir.numdepto
JOIN empleados
	ON empleados.numem = dirigir.numempdirec
;

-- ejemplo procedimiento
delimiter $$;
create procedure suma (inout valorSuma int, inout valorResta int, out valorProducto int, out valorDivision int)
begin
    set valorSuma = valor1 + valor2;
    set valorProducto = valor1 * valor2;
    set valorResta = valor1 - valor2;
    set valorDivision = valor1 / valor2;
end 
$$;

set @resul1 = 5;
set @resul2 = 7;

call suma(@resul1, @resul2, @resul3, @resul4);
select @resul1, ' ', @resul2, ' ', @resul3, ' ', @resul4;

-- ejemplos funciones
select departamentos.numde, nomde, count(*), count(extelem),
       count(distinct extelem), sum(salarem),
       avg(salarem), max(salarem), min(salarem)
from empleados join departamentos 
	using(numde)
group by numde

-- ejemplo funcion
delimiter $$
drop function if exists SumaDosNumeros
$$

create function SumaDosNumeros (num1 int, num2 int)
returns int
deterministic
begin
	declare rtdo int default 0;
	set rtdo = num1 + num2;
    
return rtdo;

end $$
delimiter ;

-- ejemplo devolver nombre completo dado su codigo
delimiter $$
create function FNombreEmpleado (numEmpleado int)
returns varchar(80)
deterministic
begin
	declare nombreEmpleado varchar(80);
	select concat_ws(' ', nomem, ape1em, ape2em) into nombreEmpleado
	from empleados
	where numem = numEmpleado;
    return nombreEmpleado;

end $$
delimiter ;
select FNombreEmpleado (190) as NombreCompleto;

-- version con procedure
delimiter $$
drop procedure if exists ProcNombreEmpleado
$$
create procedure ProcNombreEmpleado (numEmpleado int)
deterministic
begin
	select concat_ws(' ', nomem, ape1em, ape2em) as nombreEmpleado
	from empleados
	where numem = numEmpleado;

end $$
delimiter ;
call ProcNombreEmpleado (190);

-- ejemplo devuelve nombre completo y extension tejefonica en base codigo
delimiter $$
drop procedure if exists ProcNombreEmpleadoExtension
$$
create procedure ProcNombreEmpleadoExtension (numEmpleado int, out nombre varchar(80), out extension char(3))
deterministic
begin
	select concat_ws(' ', nomem, ape1em, ape2em), extelem into nombre, extension
	from empleados
	where numem = numEmpleado;

end $$
delimiter ;
call ProcNombreEmpleadoExtension (190, @nombre, @extension);
select @nombre, @extension;

-- dado un numero de empleado devolver nombre de departamente en el que se encuentra
delimiter $$
drop function if exists EjNombreDepartamento
$$
create function EjNombreDepartamento (numEmpleado int)
returns varchar(80)
deterministic
begin
	declare nombreDep varchar(80);
    
    SELECT nomde INTO nombreDep
	from empleados join departamentos
    on empleados.numde = departamentos.numde
	where numem = numEmpleado;
return nombreDep;

end $$
delimiter ;
select EjNombreDepartamento (190);



