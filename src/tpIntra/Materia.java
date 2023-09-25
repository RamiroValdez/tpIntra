package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private Integer id;
    private String nombre;
	private Integer idCorrelativa;
    private static List<Materia> listaMaterias = new ArrayList<>();

    public Materia(Integer id, String nombre, Integer idCorrelativa) {
        this.id = id;
        this.nombre = nombre;
        this.idCorrelativa = idCorrelativa;
        // Verificar si ya existe una materia con el mismo ID
    }

    public Integer getIdCorrelativa() {
		return idCorrelativa;
	}
    public void setIdCorrelativa(Integer idCorrelativa) {
		this.idCorrelativa = idCorrelativa;
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
