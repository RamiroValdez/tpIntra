package tpIntra;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaInscripciones;
	private Integer idCicloLectivo;

	public CicloLectivo(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaInscripciones, Integer idCicloLectivo){
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaInscripciones = fechaInscripciones;
		this.idCicloLectivo = idCicloLectivo;
	
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public LocalDate getFechaInscripciones() {
		return fechaInscripciones;
	}

	public void setFechaInscripciones(LocalDate fechaInscripciones) {
		this.fechaInscripciones = fechaInscripciones;
	}
	
	public Integer getIdCicloLectivo() {
		return idCicloLectivo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCicloLectivo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CicloLectivo other = (CicloLectivo) obj;
		return Objects.equals(idCicloLectivo, other.idCicloLectivo);
	}

  

}
