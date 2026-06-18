/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author usuario
 */
public class LectorJson {
    
        // A. lee el json y devuelve conjunto unico por id
    public static Set<Paciente> leerJSON(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Paciente> lista = Arrays.asList(mapper.readValue(new File(ruta), Paciente[].class));
        return new HashSet<>(lista);
    }

    // devuelve lista set
    public static Set<String> devolverLista(HashSet<Paciente> pacientes) {
        return pacientes.stream()
                .map(p -> p.getNombre().toUpperCase())
                .collect(Collectors.toSet());
    }
    
}
