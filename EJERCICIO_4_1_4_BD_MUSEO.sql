DROP TABLE IF EXISTS personal CASCADE;

CREATE TABLE personal (
    numpersonal INT PRIMARY KEY,
    nompersonal VARCHAR(100),
    dnipersonal CHAR(9)
);

DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados (
    numem INT PRIMARY KEY,
    numsegsocial CHAR(15)
) INHERITS (personal);

DROP TABLE IF EXISTS colaboradores;
CREATE TABLE colaboradores (
    numcolab INT PRIMARY KEY,
    empresa CHAR(15)
) INHERITS (personal);

CREATE OR REPLACE RULE tipopersonal_emple AS
    ON INSERT TO empleados
    WHERE EXISTS (
        SELECT 1 FROM colaboradores
        WHERE colaboradores.numpersonal = NEW.numpersonal
    )
    DO ALSO NOTHING;

CREATE OR REPLACE RULE tipopersonal_colab AS
    ON INSERT TO colaboradores
    WHERE EXISTS (
        SELECT 1 FROM empleados
        WHERE empleados.numpersonal = NEW.numpersonal
    )
    DO ALSO NOTHING;

INSERT INTO personal VALUES (1,'Juan','01000000');

INSERT INTO empleados VALUES
(2,'María','02000000',10,'0000000001'),
(3,'Alberto','03000000',11,'0000000002');

INSERT INTO colaboradores VALUES
(3,'Alberto','03000000',11,'EmpresaAlberto');
