package tpIntra;

import java.util.Objects;

public class Materia {

	private Integer id;
	private String nombre;
	private Integer idCorrelativa;
	
	public Materia(Integer id, String nombre, Integer idCorrelativa) {
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getIdCorrelativa() {
		return idCorrelativa;
	}

	public void setIdCorrelativa(Integer idCorrelativa) {
		this.idCorrelativa = idCorrelativa;
	}


	
	
}
