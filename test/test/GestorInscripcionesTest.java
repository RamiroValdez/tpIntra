package test;
import org.junit.Before;
import org.junit.Test;

import tpIntra.Alumno;
import tpIntra.Comision;
import tpIntra.Materia;
import tpIntra.Universidad;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class GestorInscripcionesTest {

    private GestorInscripciones gestor;
    private Alumno alumno;
    private Comision comision;
    private Universidad universidad;

    @Before
    public void setUp() {
        gestor = new GestorInscripciones();
        alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");
        comision = new Comision("COM-001");
        universidad = new Universidad();
    }
    
    @Before
    public void limpiarListaMaterias() {
        // Antes de cada prueba, limpiamos la lista de materias para comenzar desde cero
        Materia.limpiarListaMaterias();
    }


    @Test
    public void testInscribirAlumnoAComisionExitoso() {
        // Agregar el alumno a la Universidad (esto debe hacerse antes de la prueba)
        universidad.agregarAlumno(alumno);

        // Agregar la comisión a la Universidad (esto debe hacerse antes de la prueba)
        universidad.agregarComision(comision);
        
        alumno.agregarCorrelativaAprobada(1,"Correlativa1");
        alumno.agregarCorrelativaAprobada(2,"Correlativa90");
        alumno.agregarCorrelativaAprobada(3,"Correlativa3");
        alumno.agregarCorrelativaAprobada(4,"Correlativa4");

        // Ejecutar el método que deseas probar
        boolean inscripcionExitosa = gestor.inscribirAlumnoAComision(alumno, comision);

        // Verificar que la inscripción sea exitosa
        assertTrue(inscripcionExitosa);
    }


    @Test
    public void testInscribirAlumnoAComisionFallido() {
        // En este caso, no se agrega el alumno ni la comisión a la Universidad,
        // por lo que la inscripción debe fallar.
        
        // Intentar inscribir al alumno en la comisión
        boolean inscripcionExitosa = gestor.inscribirAlumnoAComision(alumno, comision);
        assertFalse(inscripcionExitosa); // Asegurarse de que la inscripción falle
    }
}
