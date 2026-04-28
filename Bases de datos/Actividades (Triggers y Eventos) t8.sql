-- Unidad 8. Elementos avanzados de BBDD's relacionales Actividades (Triggers y Eventos)
-- Para la base de datos empresaclase haz los siguientes ejercicios:

-- ver triggers
show triggers from empresaclase;


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

-- comprobar trigger
insert into empleados (numem, nomem, fecnaem, fecinem)
values (21, 'holis', '2025-02-17', '2025-02-17');

-- 2 Comprueba que el departamento de las personas que ejercen la dirección de los departamentos pertenezcan a dicho departamento.

use empresaclase;
delimiter $$
drop trigger if exists compruebaDepartamentoPersonas;
create trigger compruebaDepartamentoPersonas
before insert on dirigir
for each row
begin 
IF (select numde
	from empleados
    where numem = new.numempdirec)
    <> new.numdepto then
    
	SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'director debe pertenezar al departamento que dirige';
    end if;
end $$
delimiter ;

-- comprobar trigger
insert into dirigir (numdepto, numempdirec, fecinidir, fecfindir, tipodir)
values (112, 500, '2003-08-03', null, '1');