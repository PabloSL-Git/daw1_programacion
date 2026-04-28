-- listado de casas y numero de reservas que se han echo

select nomcasa, count(reservas.codreserva) as num_reservas
from casas left join reservas
-- using (codcasa)
on casas.codcasa = reservas.codcasa
where fecanulacion is null
group by casas.nomcasa;


show index from empleados

select *
from empleados ignore index
