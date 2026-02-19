ALTER TABLE deptos
ADD COLUMN id_depto INT;

ALTER TABLE deptos
DROP PRIMARY KEY;

ALTER TABLE deptos
ADD CONSTRAINT pk_deptos PRIMARY KEY (id_depto);

ALTER TABLE empleados
ADD COLUMN id_depto INT;

ALTER TABLE empleados
DROP FOREIGN KEY fk_empleados_deptos;

ALTER TABLE empleados
ADD CONSTRAINT fk_empleados_deptos
FOREIGN KEY (id_depto)
REFERENCES deptos (id_depto)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE deptos
ADD COLUMN id_depto_padre INT;

ALTER TABLE deptos
DROP FOREIGN KEY fk_deptos_deptos;

ALTER TABLE deptos
ADD CONSTRAINT fk_deptos_deptos
FOREIGN KEY (id_depto_padre)
REFERENCES deptos (id_depto)
ON DELETE NO ACTION
ON UPDATE CASCADE;

