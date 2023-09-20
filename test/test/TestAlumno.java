package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import tpIntra.Alumno;
import tpIntra.Universidad;

public class TestAlumno {

	@Test
    public void testCrearAlumno() {
        Alumno alumno = new Alumno("123456789", "Juan", "Perez", LocalDate.of(1990, 1, 1),LocalDate.of(2023,9,1));

        assertEquals("123456789", alumno.getDni());
        assertEquals("Juan", alumno.getNombre());
        assertEquals("Perez", alumno.getApellido());
        assertEquals(LocalDate.of(1990, 1, 1), alumno.getFechaNacimiento());
        assertEquals(LocalDate.of(2023,9,1), alumno.getFechaIngreso());
    }

    @Test
    public void testAgregarAlumnoDuplicado() {
        Universidad administrador = new Universidad();
        
        // Agregar un alumno con DNI único
        assertTrue(administrador.agregarAlumno(new Alumno("123456789", "Juan", "Perez", LocalDate.of(1990, 1, 1),LocalDate.of(2023,9,1))));

        // Intentar agregar otro alumno con el mismo DNI (debería fallar)
        assertFalse(administrador.agregarAlumno(new Alumno("123456789", "Ana", "Gomez", LocalDate.of(1995, 2, 2),LocalDate.of(2023, 9, 1))));
    }
    
    
}
