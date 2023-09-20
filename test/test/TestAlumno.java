package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tpIntra.Alumno;
import tpIntra.Comision;
import tpIntra.Materia;
import tpIntra.Universidad;

public class TestAlumno {

    private Universidad universidad;

    @Before
    public void setUp() {
        universidad = new Universidad();
    }

    @Before
    public void limpiarListaMaterias() {
        // Antes de cada prueba, limpiamos la lista de materias para comenzar desde cero
        Materia.limpiarListaMaterias();
    }
    
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
        // Agregar un alumno con DNI único
        assertTrue(universidad.agregarAlumno(new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023")));

        // Intentar agregar otro alumno con el mismo DNI (debería fallar)
        assertFalse(universidad.agregarAlumno(new Alumno("123456789", "Ana", "Gomez", "02/02/1995", "01/09/2023")));
    }

    @Test
    public void testAgregarConsultarCorrelativasAprobadas() {
        Alumno alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");

        // Agregar correlativas aprobadas
        Materia correlativa1 = new Materia(1, "Correlativa1");
        Materia correlativa2 = new Materia(2, "Correlativa2");
        alumno.agregarCorrelativaAprobada(correlativa1);
        alumno.agregarCorrelativaAprobada(correlativa2);

        // Consultar correlativas aprobadas
        assertEquals(2, alumno.getCorrelativasAprobadas().size());
        assertTrue(alumno.getCorrelativasAprobadas().contains(correlativa1));
        assertTrue(alumno.getCorrelativasAprobadas().contains(correlativa2));
    }

    @Test
    public void testInscripcionSinCorrelativasAprobadas() {
        Alumno alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");

        // Crear una instancia de la comisión a la que se intentará inscribir al alumno
        Comision comision = new Comision("COM-001");

        // Intentar inscribir al alumno en una comisión sin tener al menos 4 correlativas aprobadas (debería fallar)
        assertFalse(universidad.inscribirAlumnoAComision(alumno, comision));
    }

    @Test
    public void testInscripcionConCorrelativasAprobadas() {
        Alumno alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");

        // Crear una instancia de la comisión a la que se intentará inscribir al alumno
        Comision comision = new Comision("COM-001");

        // Agregar la comisión a la lista de comisiones disponibles
        universidad.agregarComision(comision);

        // Simular que el alumno tiene al menos 4 correlativas aprobadas
        for (int i = 1; i <= 4; i++) {
            Materia correlativaAprobada = new Materia(i, "Materia" + i);
            alumno.agregarCorrelativaAprobada(correlativaAprobada);
        }

        // Intentar inscribir al alumno en una comisión con al menos 4 correlativas aprobadas (debería ser exitoso)
        assertTrue(universidad.inscribirAlumnoAComision(alumno, comision));
    }

}
