-- Programas de CRUD para la basa de datos GBDturRural2015

-- ZONA
/* 1.1 Procedimiento para obtener listado de todos las zonas */
delimiter $$
drop procedure if exists buscaZonas $$
create procedure buscaZonas()
begin
	select zonas.numzona as 'Numero', 
		zonas.nomzona as 'Nombre'
	from zonas
	order by zonas.numzona;

end $$
delimiter ;

call buscaZonas();

/* 2.1 Consulta de datos de una zona */

delimiter $$

drop procedure if exists BuscaUnaZona $$
create procedure BuscaUnaZona(in numero int)
begin
    select 
        zonas.numzona as numero,
        zonas.nomzona as nombre,
        zonas.deszona as descripcion,
        casas.codcasa as numeroCasa,
        casas.nomcasa as nombreCasa
    from zonas 
    left join casas 
        on zonas.numzona = casas.codzona
    where zonas.numzona = numero;
end $$

delimiter ;

call BuscaUnaZona(1);

/* 3.1 Insertar una nueva zona */

/*
set @nuevazona = (select max(numzona)+1 from zonas);
insert into zonas
	(numzona, nomzona , deszona)
values
	(@nuevazona, zonas.nomzona, zonas.deszona); 
*/

delimiter $$
drop procedure if exists insertaZonas $$
create procedure insertaZonas(
    in nombre varchar(60),
    in descripcion varchar(200),
    out resultado int
)
begin
    declare nuevazona int;

    start transaction;
    -- Obtener siguiente ID
    select ifnull(max(numzona),0) + 1 into nuevazona
    from zonas;
    -- Insertar
    insert into zonas (numzona, nomzona, deszona)
    values (nuevazona, nombre, descripcion);
    commit;

    -- devolver resultado
    set resultado = nuevazona;
    
end $$
delimiter ;

call insertaZonas('Zona nueva', 'Descripción', @result);
select @res;

/* 4.1 update de una zona */
delimiter $$
drop procedure if exists actualizaZona $$
create procedure actualizaZona 
	(in numero int,
     in nombre varchar(60),
     in descripcion varchar(60)
     )
begin
    update zonas
    set 
		nomzona = nombre,
         deszona = descripcion
	where  numzona = numero;

end $$
delimiter ;

call actualizaZona(4, 'nombre nuevo', 'descripcion nueva');
call BuscaUnaZona(4);

/* 5.1 Eliminar una zona */

delimiter $$
drop procedure if exists borrarZona $$
create procedure borrarZona (
    in numero int
)
begin
    start transaction;
    
    if exists (
        select 1 
        from casas 
        where codzona = numero
    ) then
    
        -- Hay casas → NO borrar
        rollback;
        
    else
        delete from zonas
        where numzona = numero;
        commit;
    end if;

end $$
delimiter ;

call borrarZona();

-- TIPOS CASAS

/* 1.2 Procedimiento para obtener listado de todos los tipos */
delimiter $$
drop procedure if exists buscaTipos $$
create procedure buscaTipos()
begin
	select tiposcasa.numtipo as 'Numero', 
		tiposcasa.nomtipo as 'Nombre'
	from tiposcasa
	order by tiposcasa.numtipo;

end $$
delimiter ;

call buscaTipos();

/* 2.2 Consulta de datos de un tipo */

delimiter $$
drop procedure if exists BuscaUnTipo $$
create procedure BuscaUnTipo(in numero int)
begin
    select 
        tiposcasa.numtipo as numero,
        tiposcasa.nomtipo as nombre,
        casas.codcasa as numeroCasa,
        casas.nomcasa as nombreCasa
    from tiposcasa
    left join casas 
        on tiposcasa.numtipo = casas.codtipocasa
    where tiposcasa.numtipo = numero;
end $$
delimiter ;

call BuscaUnTipo(3);

/* 3.2 Insertar un nuevo tipo */

delimiter $$
drop procedure if exists insertaTipos $$
create procedure insertaTipos(
    in nombre varchar(60),
    out resultado int
)
begin
    declare nuevoTipo int;

    start transaction;
    -- Obtener siguiente ID
    select ifnull(max(numtipo),0) + 1 into nuevoTipo
    from tiposcasa;
    -- Insertar
    insert into tiposcasa (numtipo, nomtipo)
    values (nuevoTipo, nombre);
    commit;

    -- devolver resultado
    set resultado = nuevoTipo;
    
end $$
delimiter ;

call insertaTipos('tipo nueva', @result);
select @result;

/* 4.2 update de un tipo */
delimiter $$
drop procedure if exists actualizaTipo $$
create procedure actualizaTipo 
	(in numero int,
     in nombre varchar(60))
begin
    update tiposcasa
    set 
		nomtipo = nombre
	where  numtipo = numero;

end $$
delimiter ;

call actualizaTipo(4, 'tipo nuevo');
call BuscaUnTipo(4);

/* 5.2 Eliminar un tipo */

delimiter $$
drop procedure if exists borrarTipo $$
create procedure borrarTipo (in numero int)
begin
    start transaction;
    
    if exists (
        select 1 
        from casas 
        where codtipocasa = numero
    ) then
    
        rollback;
        
    else
        delete from tiposcasa
        where numtipo = numero;
        
        commit;
    end if;
    
end $$
delimiter ;

call borrarTipo();

/* 1.3 Procedimiento para obtener listado de todas las casas */

delimiter $$

drop procedure if exists buscaCasas $$
create procedure buscaCasas()
begin
    select 
        casas.codcasa as numero,
        casas.nomcasa as nombre,
        zonas.nomzona as zona,
        tiposcasa.nomtipo as tipo
    from casas
    left join zonas on casas.codzona = zonas.numzona
    left join tiposcasa on casas.codtipocasa = tiposcasa.numtipo
    order by casas.codcasa;

end $$
delimiter ;

call buscaCasas();

/* 2.2 Consulta de datos de una casa */

delimiter $$

drop procedure if exists BuscaUnaCasa $$
create procedure BuscaUnaCasa(in numero int)
begin
    select 
        casas.codcasa,
        casas.nomcasa,
        casas.numbanios,
        casas.numhabit,
        casas.m2,
        casas.preciobase,
        casas.minpersonas,
        casas.maxpersonas,
        casas.dirpostal,
        casas.codpostal,
        casas.poblacion,
        casas.provincia,
		zonas.nomzona,
        tiposcasa.nomtipo
    from casas
    left join zonas on casas.codzona = zonas.numzona
    left join tiposcasa on casas.codtipocasa = tiposcasa.numtipo
    where casas.codcasa = numero;
end $$
delimiter ;

call BuscaUnaCasa(2);

/* 3.2 Insertar un nueva casa */

delimiter $$
drop procedure if exists insertaCasa $$
create procedure insertaCasa(
    in nombre varchar(60),
    in banios int,
    in habitaciones int,
    in metros int,
    in minpers int,
    in maxpers int,
    in precio decimal(10,2),
    in codZona int,
    in codTipo int,
    in direccion varchar(100),
    in poblacion varchar(50),
    in provincia varchar(50),
    in codpostal char(5),
    out resultado int)
begin
    declare nuevaCasa int;
    start transaction;
    select ifnull(max(codcasa),0) + 1 into nuevaCasa
    from casas;

    insert into casas (
        codcasa, nomcasa, numbanios, numhabit, m2,
        minpersonas, maxpersonas, preciobase,
        codzona, codtipocasa,
        dirpostal, poblacion, provincia, codpostal
    )
    values (
        nuevaCasa, nombre, banios, habitaciones, metros,
        minpers, maxpers, precio,
        codZona, codTipo,
        direccion, poblacion, provincia, codpostal
    );
    
    commit;
    set resultado = nuevaCasa;
end $$
delimiter ;

call insertaCasa(
    'Casa nueva', 2, 3, 120,
    2, 6, 75.00,
    1, 1,
    'Calle Real 5',
    'Estepona',
    'Malaga',
    '29680',
    @result);
select @result;

/* 4.2 update de una casa */

delimiter $$
drop procedure if exists actualizaCasa $$
create procedure actualizaCasa(
    in numero int,
    in nombre varchar(60),
    in banios int,
    in habitaciones int,
    in metros int,
    in minpers int,
    in maxpers int,
    in precio decimal(10,2),
    in codZona int,
    in codTipo int,
    in direccion varchar(100),
    in poblacion varchar(50),
    in provincia varchar(50),
    in codpostal char(5)
)
begin
    update casas
    set 
        nomcasa = nombre,
        numbanios = banios,
        numhabit = habitaciones,
        m2 = metros,
        minpersonas = minpers,
        maxpersonas = maxpers,
        preciobase = precio,
        codzona = codZona,
        codtipocasa = codTipo,
        dirpostal = direccion,
        poblacion = poblacion,
        provincia = provincia,
        codpostal = codpostal
    where codcasa = numero;

end $$
delimiter ;

call BuscaUnaCasa(1);

/* 5.2 Eliminar una casa */

delimiter $$
drop procedure if exists borrarCasa $$
create procedure borrarCasa (in numero int)
begin
    delete from casas
    where codcasa = numero;
end $$
delimiter ;

call borrarCasa(1);