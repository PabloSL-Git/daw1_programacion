CREATE DATABASE if not exists EJER_4_1;
USE EJER_4_1;
/* CREAMOS LAS TABLAS ==> EL ORDEN ES IMPORTANTE (INTEGRIDAD REFERENCIAL) */
create table if not exists centros
    (numce int,
     nomce varchar(60),
     dirce varchar(120),
     constraint pk_centros primary key (numce)
    );
create table if not exists deptos
    (numde int,
     numce int,
     nomde varchar(60),
     presude decimal (10,2),  -- número con decimales de 10 posiciones
							  -- decimales de las cuales 2 son muméricas
							  -- valor máximo ==> 99999999,99
	constraint pk_deptos primary key (numde, numce),
    constraint fk_deptos_centros foreign key (numce)
        references centros(numce) 
            on delete no action on update cascade
    );
create table if not exists empleados
    (numem int,
     numde int,
     numce int,
     extelem char(3) null,
     fecnaem date null,
     fecinem date,
     salarem decimal (7,2),  -- 99999,99
     comisem decimal (4,2),  -- 99,99
     numhiem tinyint,        -- para valores entre -127 y 128
	-- numhiem tinyint unsigned -- para valores desde 0 a 255
     nomem varchar(20),
     ape1em varchar(20),
     ape2em varchar(20) null,
    constraint pk_empleados primary key (numem),
    constraint fk_empleados_deptos foreign key (numde, numce)
        references deptos (numde, numce)
            on delete no action on update cascade
    );
create table if not exists dirigir
    (numemdir int,
     numde int,
     numce int,
     fecinidir date,
     fecfindir date null,
    constraint pk_dirigir primary key (numemdir, numde, numce, fecinidir),
    constraint fk_dirigir_empleados foreign key (numemdir)
        references empleados (numem) on delete no action on update cascade,
    constraint fk_dirigir_deptos foreign key (numde, numce)
        references deptos (numde, numce) on delete no action on update cascade
    );

/*  DESPUES DE EJECUTAR DESCUBRIMOS QUE NOS FALTA REPRESENTAR
    LA RELACIÓN DEP (deptos a deptos) */

    ALTER TABLE deptos
        add column deptodepen int,
        add column centrodepen int,
        add constraint fk_deptos_deptos foreign key (deptodepen, centrodepen)
            references deptos (numde, numce)
                on delete no action on update cascade;
    ALTER TABLE deptos
        drop constraint fk_deptos_deptos,
        drop column deptodepen,
        drop column centrodepen;
                


/* HACER EL DIAGRAMA DESDE LA VENTANA PRINCIPAL DE WORKBENCH
    DATA - MODELING - CREATE EER MODEL FROM EXISTING DATABASE */

/* INSERCIÓN DE DATOS CON HOJA ADJUNTA ==> EL ORDEN EN EL QUE
              INSERTEMOS LOS DATOS ES IMPORTANTE (POR FOREIGN KEY) */
/*
INSERT INTO centros
    (numce, nomce, dirce)
VALUES
    (10, 'SEDE CENTRAL', 'C/ ALCALÁ 820, MADRID'),
    (20, 'RELACIÓN CON CLIENTES', 'C/ ATOCHA 405, MADRID');
*/
/* AL INSERTAR LOS DATOS EN DEPTOS DESCUBRIMOS QUE FALTA ALGO:
    1.- deptodepen y centrodepen deberían aceptar nulos
    2.- hemos olvidado el tipo de director ==>
        debería ir en la tabla dirigir
*/
/*ALTER TABLE deptos
    change column deptodepen deptodepen int null,
    modify column deptodepen int null,
    change column centrodepen centrodepen int null;
*/
/*ALTER TABLE dirigir
    add column tipodir char(1);

ALTER TABLE dirigir
    drop column tipodir; 
    
*/
INSERT INTO deptos
    (numde, numce, nomde, presude, deptodepen, centrodepen)
VALUES
    (100, 10,'DIRECCIÓN GENERAL',12000,NULL,NULL),
    (110, 20, 'DIRECCIÓN COMERCIAL', 15000, 100,10),
    (111,20,'SECTOR INDUSTRIAL',11000,110,20);


