package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String fechaIngreso;
    private List<Materia> correlativasAprobadas; // Lista de correlativas aprobadas
    private List<Comision> comisionesInscritas;
    private List<Materia> materiasAprobadas;
 
    public Alumno(String dni, String nombre, String apellido, String fechaNacimiento, String fechaIngreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.correlativasAprobadas = new ArrayList<>(); // Inicializar la lista de correlativas aprobadas como una lista vacía
        this.comisionesInscritas = new ArrayList<>();
        this.materiasAprobadas = new ArrayList<>();
    }

    // Getters y setters para los campos de la clase

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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Materia> getCorrelativasAprobadas() {
        return correlativasAprobadas;
    }

    public void setCorrelativasAprobadas(List<Materia> correlativasAprobadas) {
        this.correlativasAprobadas = correlativasAprobadas;
    }

    public List<Comision> getComisionesInscritas() {
        return comisionesInscritas;
    }

    public void setComisionesInscritas(List<Comision> comisionesInscritas) {
        this.comisionesInscritas = comisionesInscritas;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public void agregarCorrelativaAprobada(Materia correlativa) {
        // Agregar una correlativa aprobada a la lista
        correlativasAprobadas.add(correlativa);
    }

    public void quitarCorrelativaAprobada(Materia correlativa) {
        // Quitar una correlativa aprobada de la lista
        correlativasAprobadas.remove(correlativa);
    }

    public void inscribirComision(Comision comision) {
        // Agregar una comisión a la lista de comisiones inscritas
        comisionesInscritas.add(comision);
    }

    public void aprobarMateria(Materia materia) {
        // Agregar una materia aprobada a la lista de materias aprobadas
        materiasAprobadas.add(materia);
    }
    public void agregarCorrelativaAprobada(Integer id, String nombreMateria) {
        // Crear una instancia de Materia usando el nombre proporcionado
   
        Materia nuevaCorrelativa = new Materia(id, nombreMateria, null);

        // Agregar la nueva correlativa aprobada a la lista
        correlativasAprobadas.add(nuevaCorrelativa);
    }  
}

