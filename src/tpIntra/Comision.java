package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Comision {
    private String codigo;
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
	
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

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
        Aula aula = new Aula("Aula-001", 30); 
        return aula;
    }

    public String getDia() {
        String dia = "Lunes";
        return dia;
    }

    public String getTurno() {
        String turno = "Mañana";
        return turno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void asignarAula(Aula aula) {
        if (this.aula == null) {
            this.aula = new ArrayList<>();
        }
        this.aula.add(aula); 
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
                return false; 
            }
        }
        return true; 
    }
    
    public List<RegistroNotas> getRegistrosNotas() {
        return registrosNotas;
    }

    public void agregarRegistroNotas(RegistroNotas registro) {
        registrosNotas.add(registro);
    }
}
