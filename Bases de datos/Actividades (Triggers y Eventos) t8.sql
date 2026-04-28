-- Unidad 8. Elementos avanzados de BBDD's relacionales Actividades (Triggers y Eventos)
-- Para la base de datos empresaclase haz los siguientes ejercicios:

-- 1. Comprueba que no podamos contratar a empleados que no tengan 16 años.

use empresaclase;
delimiter $$
drop trigger if exists compruebaEdad;
create trigger compruebaEdad
before insert on empleados
for each row
begin
	IF YEAR(CURDATE()) - YEAR(NEW.fecnaem) < 16 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'No se puede contratar a menores de 16 años';
    end if;
end$$
delimiter ;

-- ver triggers
show triggers from empresaclase;

-- comprobar trigger
insert into empleados (numem, nomem, fecnaem, fecinem)
values (21, 'holis', '2025-02-17', '2025-02-17');
