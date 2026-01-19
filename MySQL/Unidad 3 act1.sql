-- 1 Obtener todos los datos de todos los empleados.

select *
from empleados;

-- 2 Obtener la extensión telefónica de “Juan López”.

select *
from empleados
where nomem = 'Juan' and ape1em = 'Lopez' ;

-- 3 Obtener el nombre completo de los empleados que tienen más de un hijo.

select nomem, ape1em, ape2em
from empleados
where numhiem > 0;

-- 4 Obtener el nombre completo y en una sola columna de los empleados que tienen entre 1 y 3 hijos.

select CONCAT_WS(' ', nomem, ape1em, ape2em) as nombreCompleto
from empleados
where numhiem between 1 and 3;

-- 5 Obtener el nombre completo y en una sola columna de los empleados sin comisión.

select CONCAT_WS(' ', nomem, ape1em, ape2em) as nombreCompleto
from empleados
where comisem is null ;

-- 6 Obtener la dirección del centro de trabajo “Sede Central”.

select dirce
from centros
where nomce = ' SEDE CENTRAL';

-- 7 Obtener el nombre de los departamentos que tienen más de 6000 € de presupuesto.

select nomde
from departamentos
where presude > 6000;

-- 8 Obtener el nombre de los departamentos que tienen de presupuesto 6000 € o más.
 
 select nomde
from departamentos
where presude >= 6000;

-- 9 Obtener el nombre completo y en una sola columna de los empleados que llevan trabajando
-- en nuestra empresa más de 1 año. 
-- (Añade filas nuevas para poder comprobar que tu consulta funciona).

select nomem, ape1em, ape2em,
      -- CONCAT(nomem, ' ', ape1em, ' ', IFNULL(ape2em, '')),
       CONCAT_WS(' ', nomem, ape1em, ape2em) AS nombreCompleto
from empleados
where fecinem <= '2025/1/12' 
order by fecinem;

-- 10 Obtener el nombre completo y en una sola columna de los empleados que llevan
-- trabajando en nuestra empresa entre 1 y tres años.
-- (Añade filas nuevas para poder comprobar que tu consulta funciona).

select concat(nomem,' ',
	          ape1em,' ',
              ifnull(ape2em,' ')) as nombreCompleto -- no hace falta en concat_ws

from empleados
where fecinem between date_sub(curdate(), interval 3 year)
			  and date_sub(curdate(), interval 1 year);	
		
-- 11 Prepara un procedimiento almacenado que ejecute la consulta del apartado 1 y otro que ejecute la del apartado 5.

delimiter $$;
create procedure apartado11a()
begin

select *
from empleados;

end
$$;
              
delimiter $$;
create procedure apartado11b()
begin

select CONCAT_WS(' ', nomem, ape1em, ape2em) as nombreCompleto
from empleados
where comisem is null ;

end
$$;              
        
-- 12 Prepara un procedimiento almacenado que ejecute la consulta del apartado 2 
-- de forma que nos sirva para averiguar la extensión del empleado que deseemos en cada caso.

delimiter $$;
create procedure apartado12(IN nombre varchar (20), IN apellido1 varchar (20))
begin

select extelem
from empleados
where nomem = nombre and ape1em = apellido1;

end
$$;

-- 13 Prepara un procedimiento almacenado que ejecute la consulta del apartado 3
 -- y otro para la del apartado 4 de forma que nos sirva para averiguar
 -- el nombre de aquellos que tengan el número de hijos que deseemos en cada caso.
 
 delimiter $$;
create procedure apartado13()
begin

select nomem, ape1em, ape2em
from empleados
where numhiem > 0;

end
$$;
