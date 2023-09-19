

import java.util.ArrayList;
import java.util.List;

import tpIntra.Alumno;

public class Universidad {
    private List<Alumno> listaAlumnos;

    public Universidad() {
        listaAlumnos = new ArrayList<>();
    }

    public boolean agregarAlumno(Alumno alumno) {
        // Verifica si ya existe un alumno con el mismo DNI
        for (Alumno a : listaAlumnos) {
            if (a.getDni().equals(alumno.getDni())) {
                return false; // El DNI ya existe, a ksa pete
            }
        }
        
        // Si el DNI no existe en la lista, agregar al alumno
        listaAlumnos.add(alumno);
        return true;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
}