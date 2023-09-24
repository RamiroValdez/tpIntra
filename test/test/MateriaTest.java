package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tpIntra.Materia;
import tpIntra.Universidad;

public class MateriaTest {

    @Before
    public void limpiarListaMaterias() { 
        // Antes de cada prueba, limpiamos la lista de materias para comenzar desde cero
        Materia.limpiarListaMaterias();
    }
    
    @Test
    public void testCrearVariasMaterias() {
        // Crear varias materias
        Materia materia1 = new Materia(1, "Matemáticas", null);
        Materia materia2 = new Materia(2, "Historia", null);
        Materia materia3 = new Materia(3, "Ciencias", null);

        // Verificar los atributos de las materias
        assertEquals(Integer.valueOf(1), materia1.getId());
        assertEquals("Matemáticas", materia1.getNombre());

        assertEquals(Integer.valueOf(2), materia2.getId());
        assertEquals("Historia", materia2.getNombre());

        assertEquals(Integer.valueOf(3), materia3.getId());
        assertEquals("Ciencias", materia3.getNombre());
    }
 
    @Test
    public void testNoAgregarMateriaConMismoID() {
        // Crear una materia
        Materia materia1 = new Materia(1, "Matemáticas", null);

        // Intentar crear otra materia con el mismo ID (debería fallar)
        try {
            Materia materia2 = new Materia(1, "Historia", null);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Se espera que lance una excepción, por lo que no se hace nada aquí
        }
    }

    @Test
    public void testConsultarTodasLasMaterias() {
        // Crear varias materias
        Materia materia1 = new Materia(1, "Matemáticas", null);
        Materia materia2 = new Materia(2, "Historia", null);
        Materia materia3 = new Materia(3, "Ciencias", null);

        // Consultar todas las materias existentes
        assertEquals(3, Materia.obtenerTodasLasMaterias().size());
    }

    @Test
    public void testObtenerMateriaPorID() {
        // Crear varias materias
        Materia materia1 = new Materia(1, "Matemáticas", null);
        Materia materia2 = new Materia(2, "Historia", null);
        Materia materia3 = new Materia(3, "Ciencias", null);

        // Consultar una materia por su ID
        Materia materiaConsultada = Materia.obtenerMateriaPorID(2);

        // Verificar que la materia consultada sea la correcta
        assertNotNull(materiaConsultada);
        assertEquals(Integer.valueOf(2), materiaConsultada.getId());
        assertEquals("Historia", materiaConsultada.getNombre());
    }
    
    @Test
	public void queSePuedaAgregarMateriasCorrelativas() {
		
		//Las materias se consideraran correlativas si comparten el valor identificador de correlatividad, en caso de no tener, el valor sera nulo.
		
		  Universidad administrador = new Universidad();
		 
		  Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		  Materia materiaDos = new Materia(2,"Programacion Basica II", null);
		Integer codigoCorrelatividad = 1;
		  administrador.agregarMateria(materiaUno);
		  administrador.agregarMateria(materiaDos);
		  
		  //Materia uno pasa a tener como valor correlativo a materia dos
		  
		  Boolean resultado = administrador.agregarCorrelatividad(materiaUno.getId(), codigoCorrelatividad);
		  Boolean resultado2 = administrador.agregarCorrelatividad(materiaDos.getId(), codigoCorrelatividad);
		  
		  assertTrue(resultado);
		  assertTrue(resultado2);
	}
	
	@Test
	public void queNoSePuedaAgregarMateriaCorrelativaSiLaMateriaYaTieneUnaCorrelativa() {
		
		 Universidad administrador = new Universidad();
		 
		  Materia materiaUno = new Materia(1,"Programacion Basica I", 2);
		  Materia materiaDos = new Materia(2,"Programacion Basica II", 3);
		  Materia materiaTres = new Materia(3,"Programacion Web", 2);
		  
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
		 
		  Materia materiaUno = new Materia(1,"Programacion Basica I", 2);
		  Materia materiaDos = new Materia(2,"Programacion Basica II", null);
		  
		  administrador.agregarMateria(materiaUno);
		  administrador.agregarMateria(materiaDos);
		  
		  administrador.agregarCorrelatividad(materiaUno.getId(), materiaDos.getId());
		  
		  //El Metodo corrobora que la materia tenga correlativa y luego que sea igual al valor de la correlativa a elminiar
		  
		  Boolean resultado = administrador.eliminarCorrelatividad(materiaUno.getId(), materiaDos.getId());
		  
		  assertTrue(resultado);
		
	}
}
