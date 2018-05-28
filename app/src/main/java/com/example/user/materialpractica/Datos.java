package com.example.user.materialpractica;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 21/05/2018.
 */

public class Datos {
    private static ArrayList<Persona> personas  = new ArrayList();

    public static void guardar(Persona p){
        personas.add(p);
    }

    public static ArrayList<Persona> obtener(){
        return personas;
    }

    public static void setPersonas(ArrayList<Persona> personasArray){
        personas = personasArray;
    }

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return  fotos.get(fotoSeleccionada);
    }
}
