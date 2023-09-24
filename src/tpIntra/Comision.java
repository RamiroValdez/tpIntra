package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Comision {
    private String codigo;  // Un código identificador único para la comisión
    private List<Profesor> profesores;
    private List<Alumno> alumnos;
    private CicloLectivo cicloActual;
    private List <Aula> aula;
	private Materia materia;
	private List<RegistroNotas> registrosNotas = new ArrayList<>();

    
	public Comision(String codigo) {
        this.codigo = codigo;
        this.profesores = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.registrosNotas = new ArrayList<>();
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Comision comision = (Comision) obj;
        return codigo.equals(comision.codigo);
    }

	public CicloLectivo getCicloActual() {
		return cicloActual;
	}

	public void setCicloActual(CicloLectivo cicloActual) {
		this.cicloActual = cicloActual; 
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

    public Materia getMateria() {      
        return materia;
    }

    public void asignarAula(Aula aula) {
        if (this.aula == null) {
            this.aula = new ArrayList<>(); // Inicializa la lista si es nula
        }
        this.aula.add(aula); // Agrega el objeto Aula a la lista
    }

    public void setMateria(Materia materia) {
		this.materia = materia;
	}
    
    public Boolean registrarNota(RegistroNotas nuevaNota) {

        if(registrosNotas.size()==0) {
            return registrosNotas.add(nuevaNota);
        }else {

            if(!validarQueLaNotaNoExista(nuevaNota)) {
                return false;
            }

            return registrosNotas.add(nuevaNota);

        } 

    }
    
    public Boolean validarQueLaNotaNoExista(RegistroNotas notaEvaluada) {
        for (RegistroNotas rn : registrosNotas) {
            if (rn.getAlumno().getDni().equals(notaEvaluada.getAlumno().getDni()) &&
                rn.getNota().getTipoDeExamen() == notaEvaluada.getNota().getTipoDeExamen()) {
                return false; // Si se encuentra una coincidencia, retorna false
            }
        }
        return true; // Si no se encontraron coincidencias, retorna true (puede agregar la nota)
    }


    public List<RegistroNotas> getRegistrosNotas() {
        return registrosNotas;
    }

    public void agregarRegistroNotas(RegistroNotas registro) {
        // Agregar el registro de notas a la lista
        registrosNotas.add(registro);
    }

}
