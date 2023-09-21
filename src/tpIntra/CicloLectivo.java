package tpIntra;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaInicioInscripcion;
	private Integer idCicloLectivo;
	private LocalDate fechaFinInscripcion;

	public CicloLectivo(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion, Integer idCicloLectivo){
		
		this.fechaInicio = fechaInicio; 
		this.fechaFin = fechaFin;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
		this.idCicloLectivo = idCicloLectivo;
	
	}
	
	public LocalDate getFechaFinInscripcion() {
		return fechaFinInscripcion;
	}
	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
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
