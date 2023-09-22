package test;
import org.junit.Before;
import org.junit.Test;
import tpIntra.Alumno;
import tpIntra.Aula;
import tpIntra.CicloLectivo;
import tpIntra.Comision;
import tpIntra.Materia;
import tpIntra.Profesor;
import tpIntra.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class UniversidadTest {

    private Alumno alumno;
    private Comision comision;
    private Universidad universidad;
 
    @Before
    public void setUp() {
    	universidad = new Universidad();
        alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");
        comision = new Comision("COM-001");
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
        boolean inscripcionExitosa = universidad.inscribirAlumnoAComision(alumno, comision);

        // Verificar que la inscripción sea exitosa
        assertTrue(inscripcionExitosa);
    }


    @Test
    public void testInscribirAlumnoAComisionFallido() {
        // En este caso, no se agrega el alumno ni la comisión a la Universidad,
        // por lo que la inscripción debe fallar.
        
        // Intentar inscribir al alumno en la comisión
        boolean inscripcionExitosa = universidad.inscribirAlumnoAComision(alumno, comision);
        assertFalse(inscripcionExitosa); // Asegurarse de que la inscripción falle
    }
    
    @Test
    public void testAsignarCicloLectivoAComision() {
    	
    	Comision nuevaComision = new Comision("01");
    	
    	CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,2,12), LocalDate.of(2023, 5, 28), LocalDate.of(2023, 1, 7), LocalDate.of(2023, 1, 15), 1);
    	
    	universidad.agregarComision(nuevaComision);
    	universidad.agregarCicloLectivo(nuevoCiclo);
    	
    	assertTrue(universidad.asignarCicloAComision(nuevaComision, nuevoCiclo));
    	
    }
    
    @Test
    public void testAsignarAulaAComision() {
        Universidad universidad = new Universidad();
        
        Aula aula = new Aula("Aula-001", 30);
        
        Comision comision = new Comision("COM-001");  

        comision.asignarAula(aula);
        
        assertEquals(aula, comision.getAula());
    }
    
    @Test
    public void testAsignarProfesorAComision() {
        Universidad universidad = new Universidad();
        
        Profesor profesor = new Profesor("98765432", "Maria", "Gomez", "15/05/1980", "Materia1");
        
        Comision comision = new Comision("COM-001");  

        comision.agregarProfesor(profesor);
        
        assertTrue(comision.getProfesores().contains(profesor));
    }
    
}
