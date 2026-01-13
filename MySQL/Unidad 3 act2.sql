-- ejemplo profeasora
-- departamanetos malaga

select departamentos.nomde, codpostal
from departamentos join centros
	on departamentos.numce = centros.numce -- using(numce)
where left (centros.codpostal,2) = '28'
order by departamentos.nomde asc;

-- ejemplo grande
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

-- 1 Obtener todos los datos de todos los empleados y el nombre del departamento al que pertenecen.

select concat_ws(' ', nomem, ape1em, ape2em) as nombreCompleto,
		nomde
from empleados join departamentos
	using (numde);

-- 2 Obtener la extensión telefónica y el nombre del centro de trabajo de “Juan López”.

select extelem, nomce
from empleados join departamentos
	using (numde)
JOIN centros
	using (numce)
where nomem = 'juan' and ape1em = 'lopez';


-- 3 Obtener el nombre completo y en una sola columna de los empleados del departamento “Personal” y “Finanzas”.

select concat_ws(' ', nomem, ape1em, ape2em) as nombreCompleto
from empleados join departamentos
	using (numde)
where nomde = 'PERSONAL' or 'FINANZAS';

-- 4 Obtener el nombre del director actual del departamento “Personal”.

select nomem
FROM centros JOIN departamentos
	USING (numce)
JOIN dirigir
	ON departamentos.numde = dirigir.numdepto
JOIN empleados
	ON empleados.numem = dirigir.numempdirec
where nomde = 'PERSONAL';













