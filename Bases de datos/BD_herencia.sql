-- 1. Tablas principales

CREATE TABLE IF NOT EXISTS artistas (
    codartista SERIAL PRIMARY KEY,
    nomartista VARCHAR(60),
    biografia TEXT,
    edad SMALLINT,
    fecnacim DATE
);

CREATE TABLE IF NOT EXISTS tipobras (
    codtipobra SERIAL PRIMARY KEY,
    destipobra VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS estilos (
    codestilo SERIAL PRIMARY KEY,
    nomestilo VARCHAR(40),
    desestilo VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS salas (
    codsala SERIAL PRIMARY KEY,
    nomsala VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS deptos (
    numdepto SERIAL PRIMARY KEY,
    nomdepto VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS obras (
    codobra SERIAL PRIMARY KEY,
    nomobra VARCHAR(80),
    desobra VARCHAR(150),
    feccreacion DATE,
    fecadquisicion DATE,
    valoracion DECIMAL(12,2),
    codestilo INT REFERENCES estilos(codestilo) ON UPDATE CASCADE ON DELETE NO ACTION,
    codtipobra INT REFERENCES tipobras(codtipobra) ON UPDATE CASCADE ON DELETE NO ACTION,
    codubicacion INT REFERENCES salas(codsala) ON UPDATE CASCADE ON DELETE NO ACTION,
    codartista INT REFERENCES artistas(codartista) ON UPDATE CASCADE ON DELETE NO ACTION
);

-- 2. Herencia de personal

CREATE TABLE personal (
    numpersonal SERIAL PRIMARY KEY,
    nompersonal VARCHAR(100),
    dnipersonal CHAR(9)
);

CREATE TABLE empleados (
    numem SERIAL PRIMARY KEY,
    numsegsocial CHAR(15),
    numdepto INT REFERENCES deptos(numdepto) ON UPDATE CASCADE ON DELETE NO ACTION
) INHERITS (personal);

CREATE TABLE colaboradores (
    numcolab SERIAL PRIMARY KEY,
    empresa VARCHAR(40)
) INHERITS (personal);

-- Reglas para evitar duplicados entre empleados y colaboradores
CREATE OR REPLACE RULE tipopersonal_emple AS
    ON INSERT TO empleados
    WHERE EXISTS (
        SELECT 1 FROM colaboradores
        WHERE colaboradores.numpersonal = NEW.numpersonal
    )
    DO INSTEAD NOTHING;

CREATE OR REPLACE RULE tipopersonal_colab AS
    ON INSERT TO colaboradores
    WHERE EXISTS (
        SELECT 1 FROM empleados
        WHERE empleados.numpersonal = NEW.numpersonal
    )
    DO INSTEAD NOTHING;

-- 3. Seguridad y restauraciones
-- Aquí cambiamos la FK para que referencie a personal(numpersonal)

CREATE TABLE empleados_seguridad (
    codsegur SERIAL PRIMARY KEY,
    codemple INT REFERENCES personal(numpersonal) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE restauradores (
    codrestaurador SERIAL PRIMARY KEY,
    codemple INT REFERENCES personal(numpersonal) ON UPDATE CASCADE ON DELETE NO ACTION,
    especialidad VARCHAR(60)
);

CREATE TABLE restauraciones (
    codrestaurador INT REFERENCES restauradores(codrestaurador) ON UPDATE CASCADE ON DELETE NO ACTION,
    codobra INT REFERENCES obras(codobra) ON UPDATE CASCADE ON DELETE NO ACTION,
    fecinirestauracion DATE,
    fecfinrestauracion DATE,
    observaciones TEXT,
    PRIMARY KEY (codrestaurador, codobra, fecinirestauracion)
);

-- 4. Turnos y vigilancia

CREATE TABLE turnos (
    codturno SERIAL PRIMARY KEY,
    descripcion VARCHAR(80),
    horaini TIME,
    horafin TIME
);

CREATE TABLE vigilar (
    codsala INT REFERENCES salas(codsala) ON UPDATE CASCADE ON DELETE NO ACTION,
    codsegur INT REFERENCES empleados_seguridad(codsegur) ON UPDATE CASCADE ON DELETE NO ACTION,
    codturno INT REFERENCES turnos(codturno) ON UPDATE CASCADE ON DELETE NO ACTION,
    fecini DATE,
    fecfin DATE,
    PRIMARY KEY (codsala, codsegur, codturno, fecini)
);