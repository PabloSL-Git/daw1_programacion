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
              ifnull(ape2em,' ')) as nombreCompleto

from empleados
where fecinem between date_sub(curdate(), interval 3 year)
			  and date_sub(curdate(), interval 1 year);	
              
              
              
              
              
              