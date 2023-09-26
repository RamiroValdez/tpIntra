package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String fechaIngreso;
    private List<Materia> correlativasAprobadas;
    private List<Comision> comisionesInscritas;
    private List<Materia> materiasAprobadas;
 
    public Alumno(String dni, String nombre, String apellido, String fechaNacimiento, String fechaIngreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.correlativasAprobadas = new ArrayList<>(); 
        this.comisionesInscritas = new ArrayList<>();
        this.materiasAprobadas = new ArrayList<>();
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

    public void agregarCorrelativaAprobada(Materia correlativaAprobada) {
        correlativasAprobadas.add(correlativaAprobada);
    }

    public void quitarCorrelativaAprobada(Materia correlativa) {
        correlativasAprobadas.remove(correlativa);
    }

    public void inscribirComision(Comision comision) {
        comisionesInscritas.add(comision);
    }

    public void aprobarMateria(Materia materia) {
        materiasAprobadas.add(materia);
    }
    public void agregarCorrelativaAprobada(Integer id, String nombreMateria) {
        Materia nuevaCorrelativa = new Materia(id, nombreMateria, null);
        correlativasAprobadas.add(nuevaCorrelativa);
    }  
}

