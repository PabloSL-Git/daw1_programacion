package objeto.tarea4h;

import java.time.LocalDate;

public class Prueba {
    public static void main(String[] args) {

        Animal pet = new Animal("Dogo", LocalDate.of(2018, 5, 20), "perro", 5000, "durmiendo");
        Animal pet2 = new Animal("Cato", LocalDate.of(2018, 5, 20), "gato", 5000, "durmiendo");

        Persona colega = new Persona("Paco", 25);
        Persona colega2 = new Persona("Mayo", 50);

        // Animal [] animales = new Animal[3];
        // animales[0] = pet;
        // animales[1] = pet2;

        System.out.println(pet);
        System.out.println(pet2.toString());

        // Animal petClone = Animal.AnimalClonar(pet2);

        colega.llamar(pet);
        System.out.println(pet);
        colega.llamar(pet2);
        System.out.println(pet2);

        colega2.jugar(pet2, 120);

        colega.alimentar(pet, 1000);
        System.out.println("Peso despues de comer 1Kg: " + pet.getPesoAnimal());

        colega2.jugar(pet, 100);
        System.out.println("Peso despues de jugar 200 minutos: " + pet2.getPesoAnimal());

        // Animal pet3 = new Animal("Tester", LocalDate.of(1999, 5, 20), "perro", 5000, "durmiendo");
        // Animal pet4 = new Animal("Socs", LocalDate.of(2010, 5, 20), "gato", 50, "durmiendo");

    }

}
