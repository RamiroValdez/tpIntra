package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private Integer id;
    private String nombre;
    private static List<Materia> listaMaterias = new ArrayList<>();

    public Materia(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        // Verificar si ya existe una materia con el mismo ID
        if (existeMateriaConID(id)) {
            throw new IllegalArgumentException("Ya existe una materia con el mismo ID.");
        }
        listaMaterias.add(this); // Agregar la nueva materia a la lista
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static List<Materia> obtenerTodasLasMaterias() {
        return listaMaterias; // Devuelve la lista de todas las materias
    }

    public static Materia obtenerMateriaPorID(Integer id) {
        for (Materia materia : listaMaterias) {
            if (materia.getId().equals(id)) {
                return materia; // Devuelve la materia existente
            }
        }
        return null; // No se encontró una materia con ese ID
    }

    // Método para verificar si ya existe una materia con el mismo ID
    private boolean existeMateriaConID(Integer id) {
        for (Materia materia : listaMaterias) {
            if (materia.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Método para limpiar la lista de materias (para uso en pruebas)
    public static void limpiarListaMaterias() {
        listaMaterias.clear();
    }
}
