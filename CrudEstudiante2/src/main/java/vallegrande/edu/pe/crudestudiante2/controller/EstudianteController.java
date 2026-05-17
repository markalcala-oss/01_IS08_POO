package vallegrande.edu.pe.crudestudiante2.controller;

import vallegrande.edu.pe.crudestudiante2.model.Estudiante;

import java.util.ArrayList;

public class EstudianteController {
    private ArrayList<Estudiante> list = new ArrayList<>();

    public void agregarEstudiante(String nombre, int edad, String carrera) {
        Estudiante e = new Estudiante(nombre, edad, carrera);
        list.add(e);
    }

    public ArrayList<Estudiante> listar() {
        return list;
    }
}
