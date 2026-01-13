-- 1
select *
from empleados;

-- 2
select *
from empleados
where nomem = 'Juan' and ape1em = 'Lopez' ;

-- 3
select nomem, ape1em, ape2em
from empleados
where numhiem > 0;

-- 4
select CONCAT_WS(' ', nomem, ape1em, ape2em) as nombreCompleto
from empleados
where numhiem between 1 and 3;

-- 5


-- 9
select nomem, ape1em, ape2em,
      -- CONCAT(nomem, ' ', ape1em, ' ', IFNULL(ape2em, '')),
       CONCAT_WS(' ', nomem, ape1em, ape2em) AS nombreCompleto
from empleados
where fecinem <= '2025/1/12' 
order by fecinem;

-- 10
select concat(nomem,' ',
	          ape1em,' ',
              ifnull(ape2em,' ')) as nombreCompleto

from empleados
where fecinem between date_sub(curdate(), interval 3 year)
			  and date_sub(curdate(), interval 1 year);	
              
              
              
              
              
              