package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private static List<Alumno> listaAlumnos = new ArrayList<>(); // Declarar como estática
    private static List<Comision> listaComisiones = new ArrayList<>(); // Declarar como estática
    private static List<CicloLectivo> listaCiclosLectivos = new ArrayList<>();
    
    public void imprimirComisionesDisponibles() {
        for (Comision comision : listaComisiones) {
            System.out.println(comision.getCodigo());
        }
    }

    public boolean agregarAlumno(Alumno alumno) {
        // Verifica si ya existe un alumno con el mismo DNI
        for (Alumno a : listaAlumnos) {
            if (a.getDni().equals(alumno.getDni())) {
                return false; // El DNI ya existe, no se puede agregar
            }
        }
        
        // Si el DNI no existe en la lista, agregar al alumno
        listaAlumnos.add(alumno);
        return true;
    }
    
 public boolean agregarComision(Comision comision) {
        // Verifica si ya existe una comisión con el mismo código
        for (Comision c : listaComisiones) {
            if (c.getCodigo().equals(comision.getCodigo())) {
                return false; // El código de comisión ya existe
            }
        }

        // Si el código no existe en la lista, agregar la comisión
        listaComisiones.add(comision);
        return true;
    }

    public static List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public static List<Comision> getListaComisiones() {
        return listaComisiones;
    }

    public boolean inscribirAlumnoAComision(Alumno alumno, Comision comision) {
        // Verificar si el alumno tiene al menos 4 correlativas aprobadas
        List<Materia> correlativasAprobadas = alumno.getCorrelativasAprobadas();
        if (correlativasAprobadas.size() < 4) {
            return false; // El alumno no tiene suficientes correlativas aprobadas
        }

        // Verificar si la comisión existe en la lista de comisiones disponibles
        if (!listaComisiones.contains(comision)) {
            return false; // La comisión no existe
        }

        // Verificar si el alumno ya está inscrito en la comisión
        List<Comision> comisionesInscritas = alumno.getComisionesInscritas();
        if (comisionesInscritas.contains(comision)) {
            return false; // El alumno ya está inscrito en esta comisión
        }

        // Si pasa todas las verificaciones, inscribir al alumno en la comisión
        comision.agregarAlumno(alumno);
        comisionesInscritas.add(comision);

        return true; // Inscripción exitosa
    }

	public static List<CicloLectivo> getListaCiclosLectivos() {
		return listaCiclosLectivos;
	}

}
