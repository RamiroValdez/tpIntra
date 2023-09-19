package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import tpIntra.CicloLectivo;
import tpIntra.Universidad;

public class testCicloLectivo {

	@Test
	public void crearCicloLectivo() {
		
		CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),1);
		Integer esperado = 1;
		
		assertEquals(LocalDate.of(2023,5,16),nuevoCiclo.getFechaInicio());
		assertEquals(LocalDate.of(2023,9,2),nuevoCiclo.getFechaFin());
		assertEquals(LocalDate.of(2022,8,16),nuevoCiclo.getFechaInscripciones());
		assertEquals(esperado,nuevoCiclo.getIdCicloLectivo());
	
	}
	
	@Test
	public void agregarCicloLectivo() {
		
		   Universidad administrador = new Universidad();
		   CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),1);
		   assertTrue(administrador.agregarCicloLectivo(nuevoCiclo));
		   
	}
	
	@Test
	public void queNoSePuedaAgregarUnCicloLectivoSiTieneElMismoId() {
		
		   Universidad administrador = new Universidad();
		   CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),1);
		   CicloLectivo nuevoCiclo2 = new CicloLectivo(LocalDate.of(2024,5,16),LocalDate.of(2024,9,2),LocalDate.of(2023,8,16),1);
		   administrador.agregarCicloLectivo(nuevoCiclo);
		   assertFalse(administrador.agregarCicloLectivo(nuevoCiclo2));
		  
	}
	
	@Test
	public void queNoSePuedaAgregarUnCicloLectivoSiSusFechasCoinciden() {
		
		   Universidad administrador = new Universidad();
		   CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),1);
		   CicloLectivo nuevoCiclo2 = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),2);
		   administrador.agregarCicloLectivo(nuevoCiclo);
		   assertFalse(administrador.agregarCicloLectivo(nuevoCiclo2));
		  
	}
	
	@Test
	public void queNoSePuedaAgregarUnCicloLectivoSiSusRangosDeFechaSeSuperponen() {
		
		   Universidad administrador = new Universidad();
		   
		   CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),1);
		   CicloLectivo nuevoCiclo2 = new CicloLectivo(LocalDate.of(2023,5,20),LocalDate.of(2023,8,2),LocalDate.of(2022,8,16),2);
		   
		   administrador.agregarCicloLectivo(nuevoCiclo);
		   
		   assertFalse(administrador.agregarCicloLectivo(nuevoCiclo2));
		  
	}
}
