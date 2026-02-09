/*
3. Se ha contratado a un empleado nuevo para dirigir un departamento de nueva creación. Utiliza
las sentencias sql que consideres oportunas para que aparezcan los datos del departamento
nuevo (Publicidad, con presupuesto de 15000 euros, dependiente de dirección comercial y
ubicado en el centro “Relación con clientes”), los datos del empleado que lo va a dirigir (“Rosa
del Campo Florido”, nacida el “12/6/1967”, la extensión telefónica que usará es la 930, su
salario será 2000 € y su comisión 150 €, tiene 2 hijos). Además el periodo de dirección es de un
año desde hoy y el módo de dirección es en Propiedad.
*/

INSERT INTO departamentos (nomde, presude, numce, numde)
VALUES ('Publicidad', 15000, 20, 135);

INSERT INTO empleados (nomem, ape1em, ape2em, fecnaem, extelem, salarem, comisem, numhiem, numem, fecinem)
VALUES ('Rosa', 'Campo', 'Florido', '1967-06-12', 930, 2000, 150, 2, 100, CURDATE());

/*4. El departamento “Sector industrial” se ha trasladado al centro “Sede central”.*/

UPDATE departamentos
SET numce = 10
WHERE nomde = 'SECTOR INDUSTRIAL';

/*
Hemos contratado a dos nuevos empleados que van a formar parte del nuevo departamento
“Publicidad”. Sus datos son “Pedro González Sánchez” y “Juan Torres Campos” nacidos el
“12/2/1972” y “25/9/1975” respectivamente, ambos van a ganar 1400 € y no tendrán comisión.
El primero tiene 1 hijo y el segundo no tiene hijos. Compartirán la extensión telefónica 940.
*/

