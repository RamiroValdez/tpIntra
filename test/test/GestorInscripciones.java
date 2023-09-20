package test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import tpIntra.Alumno;
import tpIntra.CicloLectivo;
import tpIntra.Comision;
import tpIntra.Materia;
import tpIntra.Universidad;

public class GestorInscripciones {

    private List<Comision> comisiones = new ArrayList<>();
    private Date fechaInicioInscripcion;
	private Date fechaaFinInscripcion;


    public boolean inscribirAlumnoAComision(Alumno alumno, Comision comision) {
        
    	// Verificar que el alumno y la comisión estén dados de alta
        if (!esAlumnoAlta(alumno) || !esComisionAlta(comision)) {
            return false;
        }

        // Verificar que el alumno tenga aprobadas todas las correlativas (4 o más)
        if (!tieneCorrelativasAprobadas(alumno)) {
            return false;
        }

        // Verificar que la inscripción no esté fuera de fecha
        if (esFueraDeFechaInscripcion()) {
            return false;
        }

        // Verificar que no se exceda la cantidad de alumnos permitidos en el aula
        if (excedeCapacidadAula(comision)) {
            return false;
        }

        // Verificar que el alumno no esté inscrito a otra comisión el mismo día y turno
        if (estaInscritoEnOtraComision(alumno, comision)) {
            return false;
        }

        // Verificar que el alumno no haya aprobado previamente la materia
        if (yaAproboMateria(alumno, comision)) {
            return false;
        }

        // Si todas las verificaciones pasan, inscribir al alumno a la comisión
        comision.agregarAlumno(alumno);
        return true;
    }

    private boolean esAlumnoAlta(Alumno alumno) {
        // Supongamos que tienes una lista de alumnos dados de alta en la Universidad
        List<Alumno> listaAlumnos = Universidad.getListaAlumnos();

        // Verificar si el alumno está en la lista de alumnos
        return listaAlumnos.contains(alumno);
    }

    private boolean esComisionAlta(Comision comision) {
        // Supongamos que tienes una lista de comisiones dadas de alta en la Universidad
        List<Comision> listaComisiones = Universidad.getListaComisiones();

        // Verificar si la comisión está en la lista de comisiones
        return listaComisiones.contains(comision);
    }

    private boolean tieneCorrelativasAprobadas(Alumno alumno) {
        // Supongamos que tienes una lista de correlativas aprobadas por el alumno
        List<Materia> correlativasAprobadas = alumno.getCorrelativasAprobadas();

        // Verificar si el alumno tiene al menos 4 correlativas aprobadas
        return correlativasAprobadas.size() >= 4;
    }

    private boolean esFueraDeFechaInscripcion() {
        // Supongamos que tienes las fechas de inicio y fin de inscripción
        Date fechaActual = new Date();
        Date fechaInicioInscripcion = obtenerFechaInicioInscripcion();
        Date fechaFinInscripcion = obtenerFechaFinInscripcion();

        // Verificar si la fecha actual está dentro del período de inscripción
        return fechaActual.compareTo(fechaInicioInscripcion) < 0 || fechaActual.compareTo(fechaFinInscripcion) > 0;
    }

    public Date obtenerFechaFinInscripcion() {
        // Supongamos que la fecha de finalización de inscripción es el 15 de enero de 2023 a las 23:59:59
    	
    	List<CicloLectivo> cicloLectivo = Universidad.getListaCiclosLectivos();
    	
    	
    	
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER); // Enero
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return cal.getTime();
    }


	 Date obtenerFechaInicioInscripcion() {
        // Supongamos que la fecha de inicio de inscripción es el 1 de enero de 2023 a las 00:00:00
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER); // Enero
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();
    }

	private boolean excedeCapacidadAula(Comision comision) {
        // Supongamos que tienes la capacidad máxima del aula de la comisión
        int capacidadMaximaAula = comision.getAula().getCapacidadMaxima();

        // Verificar si la cantidad de alumnos inscritos en la comisión excede la capacidad del aula
        return comision.getAlumnos().size() >= capacidadMaximaAula;
    }

    private boolean estaInscritoEnOtraComision(Alumno alumno, Comision comision) {
        // Supongamos que tienes la lista de comisiones a las que el alumno está inscrito
        List<Comision> comisionesInscritas = alumno.getComisionesInscritas();

        // Supongamos que también tienes la información de día y turno de la comisión
        String diaComisionActual = comision.getDia();
        String turnoComisionActual = comision.getTurno();

        // Verificar si el alumno está inscrito en otra comisión el mismo día y turno
        for (Comision otraComision : comisionesInscritas) {
            if (otraComision != comision &&
                diaComisionActual.equals(otraComision.getDia()) &&
                turnoComisionActual.equals(otraComision.getTurno())) {
                return true;
            }
        }
        return false;
    }

    private boolean yaAproboMateria(Alumno alumno, Comision comision) {
        // Supongamos que tienes la lista de materias aprobadas por el alumno
        List<String> materiasAprobadas = alumno.getMateriasAprobadas();

        // Supongamos que también tienes la materia de la comisión
        String materiaComision = comision.getMateria();

        // Verificar si el alumno ya aprobó la materia de la comisión
        return materiasAprobadas.contains(materiaComision);
    }

    public void configurarFechaInscripcionValida() {
        // Obtener las fechas de inicio y fin de inscripción
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER); // Mes de septiembre
        cal.set(Calendar.DAY_OF_MONTH, 1); // Día 1 de septiembre
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date fechaInicio = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 15); // Día 15 de septiembre
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date fechaFin = cal.getTime();

        // Establecer las fechas de inicio y fin de inscripción en el período válido
        setFechaInicioInscripcion(fechaInicio);
        setFechaFinInscripcion(fechaFin);
    }


    private void setFechaFinInscripcion(Date nuevaFechaFin) {
		this.fechaaFinInscripcion = nuevaFechaFin;
		
	}

	private void setFechaInicioInscripcion(Date nuevaFechaInicio) {
        this.fechaInicioInscripcion = nuevaFechaInicio;
    }


}
