-- TEORIA
-- obtener -> procedimiento

-- devuelva -> 1 dato -> funcion
--          -> varios datos -> procedimiento con parametro de salida	

-- drop procedure

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

-- Obtener el nombre y el presupuesto de los departamentos que están ubicados en la “SEDE CENTRAL”. (Dos procedimientos)
-- en procedimiento
delimiter $$;
create procedure apartado5practicaA(ubicacion varchar (20))
begin

select numde, presude, nomce
from  departamentos join centros
	using (numce)
where nomce = ubicacion
order by numde desc;

end
$$

-- en procedimiento con parametros de salida
delimiter $$;
create procedure apartado5practicaB(out nombreDepto varchar (60), in nombreCentro varchar(60), out presupuestoDepto decimal(10,2))
begin

select departamentos.nomde, departamentos.presude into nombreDepto, presupuestoDepto
from  departamentos join centros
	using (numce)
where trim(centros.nomce) = trim(nombreCentro)
order by numde desc
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
