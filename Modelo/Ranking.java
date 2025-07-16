package Modelo;

import java.io.*;
import java.util.*;

public class Ranking {

    private final String archivoUsuarios = "registroUsuarios.txt";

    public List<Usuarios> obtenerRanking() {
        List<Usuarios> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int puntaje = Integer.parseInt(partes[1].trim());

                    Usuarios u = new Usuarios();
                    u.setUsuario(nombre);
                    u.setMax_Puntaje(puntaje);
                    lista.add(u);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ordenar por puntaje descendente
        lista.sort((u1, u2) -> Integer.compare(u2.getMax_Puntaje(), u1.getMax_Puntaje()));

        return lista;
    }
}
