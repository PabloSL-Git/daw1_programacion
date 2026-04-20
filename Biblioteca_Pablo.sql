create database if not exists Biblioteca_Pablo;
use Biblioteca_Pablo;


-- TABLA BIBLIOTECA

drop table if exists Biblioteca;
create table Biblioteca
(
 id_biblioteca int,
 nombre varchar(100) not null,
 direccion varchar(150),
 constraint pk_biblioteca primary key (id_biblioteca)
);


-- TABLA AUTOR

drop table if exists Autor;
create table Autor
(
 id_autor int,
 nombre varchar(100) not null,
 nacionalidad varchar(100),
 constraint pk_autor primary key (id_autor)
);


-- TABLA LIBRO

drop table if exists Libro;
create table Libro
(
 id_libro int,
 titulo varchar(150) not null,
 anio_publicacion year,
 estado varchar(50),
 id_autor int,
 id_biblioteca int,
 constraint pk_libro primary key (id_libro),
 constraint fk_libro_autor foreign key (id_autor) references Autor(id_autor)
    on delete no action on update cascade,
 constraint fk_libro_biblioteca foreign key (id_biblioteca) references Biblioteca(id_biblioteca)
    on delete no action on update cascade
);


-- TABLA LECTOR

drop table if exists Lector;
create table Lector
(
 id_lector int,
 nombre varchar(100) not null,
 email varchar(100),
 telefono varchar(20),
 id_biblioteca int,
 constraint pk_lector primary key (id_lector),
 constraint fk_lector_biblioteca foreign key (id_biblioteca) references Biblioteca(id_biblioteca)
    on delete no action on update cascade
);


-- TABLA CREDENCIAL 

drop table if exists Credencial;
create table Credencial
(
 id_credencial int,
 numero_tarjeta varchar(50) not null,
 fecha_emision date,
 id_lector int,
 constraint pk_credencial primary key (id_credencial),
 constraint uq_credencial_lector unique (id_lector),
 constraint uq_numero_tarjeta unique (numero_tarjeta),
 constraint fk_credencial_lector foreign key (id_lector) references Lector(id_lector)
    on delete no action on update cascade
);


-- TABLA PRESTAMO

drop table if exists Prestamo;
create table Prestamo
(
 id_prestamo int,
 fecha_inicio date not null,
 fecha_fin date,
 id_lector int,
 id_libro int,
 constraint pk_prestamo primary key (id_prestamo),
 constraint fk_prestamo_lector foreign key (id_lector) references Lector(id_lector)
    on delete no action on update cascade,
 constraint fk_prestamo_libro foreign key (id_libro) references Libro(id_libro)
    on delete no action on update cascade
);