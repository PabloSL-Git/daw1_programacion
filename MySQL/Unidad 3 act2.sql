-- 1 Obtener todos los datos de todos los empleados y el nombre del departamento al que pertenecen.
SELECT empleados.*, nomde -- departamentos.nomde
FROM empleados join departamentos 
	on empleados.numde = departamentos.numde;

-- 2 Obtener la extensión telefónica y el nombre del centro de trabajo de “Juan López”.
SELECT empleados.extelem as ExtensionTelefonica, centros.nomce as CentroTrabajo
	FROM empleados join departamentos 
		on empleados.numde = departamentos.numde
			join centros
				on departamentos.numce = centros.numce
	WHERE empleados.nomem = 'Juan' and empleados.ape1em = 'López';
	-- o también:
    -- WHERE concat_ws(' ',empleados.nomem,empleados.ape1em) = 'Juan López';


-- 3 Obtener el nombre completo y en una sola columna de los empleados del departamento “Personal” y “Finanzas”.
-- incluimos el nombre del departamento solo para comprobar, como no nos lo pide el enunciado, deberíamos quitarlo
SELECT nomde, concat(empleados.nomem, ' ', empleados.ape1em, ' ',
 			  ifnull(empleados.ape2em, ''))
	AS NOMBRECOMPLETO
FROM empleados join departamentos 
	on empleados.numde = departamentos.numde
WHERE departamentos.nomde = 'Personal' OR
		departamentos.nomde = 'Finanzas'
-- vamos a mostrar los resultados ordenados:
ORDER BY nomde, ape1em, ape2em, nomem; 
-- también podemos obtener la misma ordenación escribiendo alguna de las siguientes opciones:
-- ORDER BY 1, 2;
-- ORDER BY nomde, NOMBRECOMPLETO;
-- ORDER BY nomde, concat(empleados.nomem, empleados.ape1em, ifnull(empleados.ape2em, ''));
-- SI QUISIÉRAMOS ORDENAR SOLO POR EL NOMBRE DE LOS EMPLEADOS, QUITARÍAMOS LAS REFERENCIAS A nomde

-- 4 Obtener el nombre del director actual del departamento “Personal”.
SELECT concat(empleados.nomem, ' ', empleados.ape1em, ' ',
	ifnull(empleados.ape2em, '')) as NombreDireccion, dirigir.fecinidir as fechaDesde, 
    ifnull(dirigir.fecfindir,'Sin fecha fin de dirección') as fechaHasta -- en caso de que la fecha fin de dirección fuese NULL, mostraría el texto 'Sin fecha fin de dirección'
FROM empleados join dirigir 
	on empleados.numem = dirigir.numempdirec
		join departamentos on dirigir.numdepto = departamentos.numde
WHERE departamentos.nomde = 'Personal' and 
	fecinidir <= curdate() and (fecfindir is null or fecfindir >= curdate());

/* O TAMBIÉN:

WHERE departamentos.nomde = 'Personal' and 
	curdate() between fecinidir and
		ifnull(fecfindir,date_add(curdate(), interval 1 day))
*/

-- 5 Obtener el nombre y el presupuesto de los departamentos que están ubicados en la “SEDE CENTRAL”.
SELECT departamentos.nomde, departamentos.presude
FROM departamentos join centros 
	on departamentos.numce = centros.numce
WHERE trim(centros.nomce) = 'SEDE CENTRAL'; 

-- 6 Obtener el nombre de los centros de trabajo cuyo presupuesto esté entre 100000 € y 150000 €.
-- NOTA, si en un centro hubiera más de un departamento que cumpla la condición, el centro saldrá repetido, por lo que añadimos DISTINCTº
SELECT DISTINCT centros.nomce
FROM centros join departamentos 
	on centros.numce= departamentos.numce
where departamentos.presude between 100000 and 150000;

-- 7 Obtener las extensiones telefónicas del departamento “Finanzas”. No deben salir extensiones repetidas.
SELECT distinct empleados.extelem
FROM empleados join departamentos 
		on empleados.numde= departamentos.numde
WHERE departamentos.nomde = 'Finanzas';
-- Podemos probar con otro departamento:
-- WHERE departamentos.nomde = 'Proceso de datos';

-- 8 Obtener el nombre completo y en una sola columna de todos los directores que ha tenido un departamento cualquiera.
SELECT concat_ws(' ', nomem, ape1em, ape2em) as nombreCompleto
from empleados join departamentos
	using (numde)
join dirigir
	ON empleados.numem = dirigir.numempdirec
;

select CONCAT(empleados.ape1em, ifnull(concat(' ', empleados.ape2em), ''),', ', empleados.nomem) as nombreDir
from departamentos join dirigir
	on departamentos.numde = dirigir.numdepto
		join empleados 
	on empleados.numem = dirigir.numempdirec
-- where departamentos.nomde ='Finanzas';
where departamentos.nomde ='DIRECCION GENERAL';




