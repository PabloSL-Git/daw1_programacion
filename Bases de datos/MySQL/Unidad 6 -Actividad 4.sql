-- 30 Obtener el número de empleados y el salario medio
-- de cada departamento, solo si el salario medio es mayor a 1500

select numde, count(*) as total_empleados, avg(salarem) as salario_medio
from empleados
group by numde
having avg(salarem) > 1500
order by salario_medio desc;

-- 32 Obtener los departamentos donde hay más de 3 empleados
-- y mostrar la suma total de sus salarios

select numde, sum(salarem) as suma_salarios
from empleados
group by numde
having count(*) > 3
order by suma_salarios desc;

-- 40. Para la base de datos de turismo rural, queremos obtener
-- las casas disponibles para una zona y un rango de fecha dados

select *
from casas
where zona = 'NORTE' -- cambiar por la zona deseada
and id_casa not in (
    select id_casa
    from reservas
    where fecha_inicio <= '2024-12-31'
    and fecha_fin >= '2024-12-01'
);

-- 41. Para la BD de promociones, obtener el precio a día de hoy de cada producto

select id_producto, nombre, precio
from productos
join precios on id_producto = id_producto
where current_date between fecha_inicio and fecha_fin;