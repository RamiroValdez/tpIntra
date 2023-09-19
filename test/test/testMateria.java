package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tpIntra.Materia;
import tpIntra.Universidad;

public class testMateria {

	@Test
	public void queSePuedaCrearUnaMateria() {
		
		Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		
		Integer numEsperado = 1; 
		assertEquals(numEsperado,materiaUno.getId());
		assertEquals("Programacion Basica I", materiaUno.getNombre());
		
	}
	
	@Test
	public void queSePuedaAgregarUnaMateria() {
		
		   Universidad administrador = new Universidad();
		   
		   Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		   
		   //Prueba basica para agregar una materia
		   
		   Boolean resultado = administrador.agregarMateria(materiaUno);
		   
		   assertTrue(resultado);
		
	}
	
	@Test
	public void queNoSePuedaAgregarUnaMateriaSiTieneIdRepetido() {
		
		   Universidad administrador = new Universidad();
		   
		   //Se crean dos materias con mismo identificador para forzar el falso.
		   
		   Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		   Materia materiaDos = new Materia(1,"Programacion Basica II", null);
		   
		   administrador.agregarMateria(materiaUno);
		   
		   Boolean resultado = administrador.agregarMateria(materiaDos);
		   
		   assertFalse(resultado);
		
	}
	
	@Test
	public void queSePuedaAgregarMateriasCorrelativas() {
		
		//Las materias se consideraran correlativas si comparten el valor identificador de la materia a la que son correlativas, en caso de no tener, el valor sera nulo.
		
		  Universidad administrador = new Universidad();
		 
		  Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		  Materia materiaDos = new Materia(2,"Programacion Basica II", null);
		
		  administrador.agregarMateria(materiaUno);
		  administrador.agregarMateria(materiaDos);
		  
		  //Materia uno pasa a tener como valor correlativo a materia dos
		  
		  Boolean resultado = administrador.agregarCorrelatividad(materiaUno.getId(), materiaDos.getId());
		  
		  assertTrue(resultado);
		  
	}
	
	@Test
	public void queNoSePuedaAgregarMateriaCorrelativaSiLaMateriaYaTieneUnaCorrelativa() {
		
		 Universidad administrador = new Universidad();
		 
		  Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		  Materia materiaDos = new Materia(2,"Programacion Basica II", null);
		  Materia materiaTres = new Materia(3,"Programacion Web", null);
		  
		  administrador.agregarMateria(materiaUno);
		  administrador.agregarMateria(materiaDos);
		  administrador.agregarMateria(materiaTres);
		  
		  administrador.agregarCorrelatividad(materiaUno.getId(), materiaDos.getId());
		  Boolean resultado = administrador.agregarCorrelatividad(materiaUno.getId(), materiaTres.getId());
		  
		  assertFalse(resultado);
		  
	}
	
	@Test
	public void queSePuedaEliminarUnaCorrelatividad() {
		
		  Universidad administrador = new Universidad();
		 
		  Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		  Materia materiaDos = new Materia(2,"Programacion Basica II", null);
		  
		  administrador.agregarMateria(materiaUno);
		  administrador.agregarMateria(materiaDos);
		  
		  administrador.agregarCorrelatividad(materiaUno.getId(), materiaDos.getId());
		  
		  //El Metodo corrobora que la materia tenga correlativa y luego que sea igual al valor de la correlativa a elminiar
		  
		  Boolean resultado = administrador.eliminarCorrelatividad(materiaUno.getId(), materiaDos.getId());
		  
		  assertTrue(resultado);
		
	}

}
