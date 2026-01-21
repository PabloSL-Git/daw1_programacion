-- Nos piden que para la BD empresaclase y dado el número de empleado (numem), 
-- preparemos una rutina con la que podamos obtener la dirección en la que trabaja dicho empleado.
-- Diseña las siguientes rutinas:

-- a
delimiter $$;
create procedure TareaDeClase1(in numeroEmpleado int (60))
begin

SELECT dirce
FROM centros JOIN departamentos
	USING (numce)
JOIN empleados
	USING (numde)
where numem = numeroEmpleado;

end
$$;

-- b
delimiter $$;
create procedure TareaDeClase1(in numeroEmpleado int (60), OUT direccion VARCHAR(60))
begin

SELECT dirce into direccion
FROM centros JOIN departamentos
	USING (numce)
JOIN empleados
	USING (numde)
where numem = numeroEmpleado;

end
$$;

-- c

