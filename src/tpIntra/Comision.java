package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Comision {
    private Integer codigo;  // Un código identificador único para la comisión
    private List<Profesor> profesores;
    private List<Alumno> alumnos;
	private CicloLectivo cicloPerteneciente;
    private Materia materiaAsignada;
    private String turno;
    
    public Comision(Integer codigo,Materia materiaAsignada, CicloLectivo cicloPerteneciente, String turno) {
        this.codigo = codigo;
        this.materiaAsignada = materiaAsignada;
        this.turno = turno;
        this.cicloPerteneciente = cicloPerteneciente;
        this.profesores = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }
    
    public CicloLectivo getCicloPerteneciente() {
		return cicloPerteneciente;
	}
    
 
    public void setCicloPerteneciente(CicloLectivo cicloPerteneciente) {
		this.cicloPerteneciente = cicloPerteneciente;
	}
    
    public Materia getMateriaAsignada() {
    	return materiaAsignada;
    }
    public void setMateriaAsignada(Materia materia) {
    	this.materiaAsignada = materia;
    }
    
    public String getTurno() {
    	return turno;
    }
    
    public void setTurno(String turno) {
    	this.turno = turno;
    }
    // Métodos para agregar profesores, alumnos y registros de exámenes
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    // Métodos para obtener información de la comisión
    public Integer getCodigo() {
        return codigo;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Aula getAula() {
        // Supongamos que tienes una instancia de la clase Aula que representa el aula de la inscripción
        Aula aula = new Aula("Aula-001", 30); // Supongamos que "Aula-001" es el identificador y 30 es la capacidad máxima de alumnos

        return aula;
    }

    public String getDia() {
        // Supongamos que el día de la semana es "Lunes" en este ejemplo
        String dia = "Lunes"; // Puedes ajustar esto según el día real de tu inscripción

        return dia;
    }




}
