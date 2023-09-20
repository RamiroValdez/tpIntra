package tpIntra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private List<String> correlativasAprobadas; // Lista de correlativas aprobadas

    public Alumno(String dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.correlativasAprobadas = new ArrayList<>(); // Inicializar la lista como una lista vacía
    }

    public List<String> getCorrelativasAprobadas1() {
        // Supongamos que tienes una lista de correlativas aprobadas almacenada en la clase Alumno
        List<String> correlativasAprobadas = new ArrayList<>();

        // Aquí puedes agregar lógica para obtener las correlativas aprobadas del alumno
        // Puedes obtener estas correlativas de una base de datos, una lista interna en la clase Alumno, u otro lugar.

        // Ejemplo: Agregar algunas correlativas aprobadas
        correlativasAprobadas.add("Correlativa1");
        correlativasAprobadas.add("Correlativa2");
        correlativasAprobadas.add("Correlativa3");

        return correlativasAprobadas;
    }
    
    public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	    public void agregarCorrelativaAprobada(String correlativa) {
	        // Agregar una correlativa aprobada a la lista
	        correlativasAprobadas.add(correlativa);
	    }

	    public void quitarCorrelativaAprobada(String correlativa) {
	        // Quitar una correlativa aprobada de la lista
	        correlativasAprobadas.remove(correlativa);
	    }
	    
	    public List<String> getCorrelativasAprobadas() {
	        // Supongamos que tienes una lista de correlativas aprobadas almacenada en la clase Alumno
	        List<String> correlativasAprobadas = new ArrayList<>();

	        // Aquí puedes agregar lógica para obtener las correlativas aprobadas del alumno
	        // Puedes obtener estas correlativas de una base de datos, una lista interna en la clase Alumno, u otro lugar.

	        // Ejemplo: Agregar algunas correlativas aprobadas
	        correlativasAprobadas.add("Correlativa1");
	        correlativasAprobadas.add("Correlativa2");
	        correlativasAprobadas.add("Correlativa3");

	        return correlativasAprobadas;
	    }
	    
	    
	public List<Comision> getComisionesInscritas() {
	    // Supongamos que tienes una lista de comisiones inscritas por el alumno almacenada en la clase Alumno
	    List<Comision> comisionesInscritas = new ArrayList<>();

	    // Aquí puedes agregar lógica para obtener las comisiones a las que se ha inscrito el alumno
	    // Puedes obtener esta información de una base de datos, una lista interna en la clase Alumno u otro lugar.

	    // Ejemplo: Agregar algunas comisiones inscritas
	    comisionesInscritas.add(new Comision("COM-001"));
	    comisionesInscritas.add(new Comision("COM-002"));
	    comisionesInscritas.add(new Comision("COM-003"));

	    return comisionesInscritas;
	}

	public List<String> getMateriasAprobadas() {
	    // Supongamos que tienes una lista de materias aprobadas almacenada en la clase Alumno
	    List<String> materiasAprobadas = new ArrayList<>();

	    // Aquí puedes agregar lógica para obtener las materias aprobadas del alumno
	    // Puedes obtener esta información de una base de datos, una lista interna en la clase Alumno u otro lugar.

	    // Ejemplo: Agregar algunas materias aprobadas
	    materiasAprobadas.add("Materia1");
	    materiasAprobadas.add("Materia2");
	    materiasAprobadas.add("Materia3");

	    return materiasAprobadas;
	}


    
}
