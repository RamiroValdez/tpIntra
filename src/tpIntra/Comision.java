package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Comision {
    private String codigo;  // Un código identificador único para la comisión
    private List<Profesor> profesores;
    private List<Alumno> alumnos;
	private CicloLectivo cicloPerteneciente;
    
    public Comision(String codigo, CicloLectivo cicloPerteneciente) {
        this.codigo = codigo;
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
    
    
    // Métodos para agregar profesores, alumnos y registros de exámenes
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    // Métodos para obtener información de la comisión
    public String getCodigo() {
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

    public String getTurno() {
        // Supongamos que el turno es "Mañana" en este ejemplo
        String turno = "Mañana"; // Puedes ajustar esto según el turno real de tu inscripción

        return turno;
    }

    public String getMateria() {
        // Supongamos que el nombre de la materia es "Materia1" en este ejemplo
        String materia = "Materia1"; // Puedes ajustar esto según el nombre real de la materia

        return materia;
    }




}
