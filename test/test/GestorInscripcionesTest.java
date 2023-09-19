package test;

import org.junit.Test;

import tpIntra.Alumno;
import tpIntra.Comision;
import tpIntra.Universidad;

import static org.junit.Assert.*;

public class GestorInscripcionesTest {

	@Test
	public void testInscribirAlumnoAComisionExitoso() {
	    GestorInscripciones gestor = new GestorInscripciones();
	    Alumno alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");
	    Comision comision = new Comision("COM-001");
	    Universidad miUniversidad = new Universidad();

	    // Agregar el alumno a la Universidad
	    boolean alumnoAgregado = miUniversidad.agregarAlumno(alumno);
	    assertTrue(alumnoAgregado); // Asegurarse de que el alumno se agregue correctamente

	    // Agregar la comisión a la Universidad
	    boolean comisionAgregada = miUniversidad.agregarComision(comision);
	    assertTrue(comisionAgregada); // Asegurarse de que la comisión se agregue correctamente

	    boolean inscripcionExitosa = gestor.inscribirAlumnoAComision(alumno, comision);
	    assertTrue(inscripcionExitosa);
	}


    @Test
    public void testInscribirAlumnoAComisionFallido() {
        GestorInscripciones gestor = new GestorInscripciones();
        Alumno alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");
        Comision comision = new Comision("COM-001");
        Universidad miUniversidad = new Universidad();

        // Simula condiciones en las que la inscripción debería fallar
        boolean inscripcionFallida = gestor.inscribirAlumnoAComision(alumno, comision);
        assertFalse(inscripcionFallida);
    }
}
