package tpIntra;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private Integer id;
    private String nombre;
	private Integer idCorrelativa;

    public Materia(Integer id, String nombre, Integer idCorrelativa) {
        this.id = id;
        this.nombre = nombre;
        this.idCorrelativa = idCorrelativa;
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

}
