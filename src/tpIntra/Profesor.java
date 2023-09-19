package tpIntra;

public class Profesor {
	
	private String dni;
	private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String materiaAsignada;
    
    public Profesor(String dni, String nombre, String apellido, String fechaNacimiento, String materiaAsignada) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.materiaAsignada = materiaAsignada;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getMateriaAsignada() {
		return materiaAsignada;
	}

	public void setMateriaAsignada(String materiaAsignada) {
		this.materiaAsignada = materiaAsignada;
	}

}
