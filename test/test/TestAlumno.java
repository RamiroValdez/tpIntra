package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tpIntra.Alumno;
import tpIntra.Universidad;

public class TestAlumno {

	@Test
    public void testCrearAlumno() {
        Alumno alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");

        assertEquals("123456789", alumno.getDni());
        assertEquals("Juan", alumno.getNombre());
        assertEquals("Perez", alumno.getApellido());
        assertEquals("01/01/1990", alumno.getFechaNacimiento());
        assertEquals("01/09/2023", alumno.getFechaIngreso());
    }

    @Test
    public void testAgregarAlumnoDuplicado() {
        Universidad administrador = new Universidad();
        
        // Agregar un alumno con DNI único
        assertTrue(administrador.agregarAlumno(new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023")));

        // Intentar agregar otro alumno con el mismo DNI (debería fallar)
        assertFalse(administrador.agregarAlumno(new Alumno("123456789", "Ana", "Gomez", "02/02/1995", "01/09/2023")));
    }
    
    
}
