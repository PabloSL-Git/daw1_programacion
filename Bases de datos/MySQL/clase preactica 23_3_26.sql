-- hallar el salario minimo y maximo para cada grupo de empleados, con igula numero de hijos
-- , que tienen al menos 1 y solo si hay mas de un empleado en el grupo

SELECT ifnull(numhiem,'indeterminado'), MIN(salarem) AS salario_minimo, MAX(salarem) AS salario_maximo
FROM empleados
where numhiem >= 1  
GROUP BY ifnull(numhiem,'indeterminado')
having count(numem) > 1
order by ifnull(numhiem,'indeterminado');

-- hallar el maximo valor de la suma de los salarios de los departamentos

SELECT nomde, SUM(salarem) AS suma_salarios
FROM empleados
JOIN departamentos USING (numde)
GROUP BY nomde
ORDER BY suma_salarios;
