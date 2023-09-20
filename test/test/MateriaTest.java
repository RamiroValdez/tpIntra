package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tpIntra.Materia;

public class MateriaTest {

    @Before
    public void limpiarListaMaterias() {
        // Antes de cada prueba, limpiamos la lista de materias para comenzar desde cero
        Materia.limpiarListaMaterias();
    }

    @Test
    public void testCrearVariasMaterias() {
        // Crear varias materias
        Materia materia1 = new Materia(1, "Matemáticas");
        Materia materia2 = new Materia(2, "Historia");
        Materia materia3 = new Materia(3, "Ciencias");

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
        Materia materia1 = new Materia(1, "Matemáticas");

        // Intentar crear otra materia con el mismo ID (debería fallar)
        try {
            Materia materia2 = new Materia(1, "Historia");
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Se espera que lance una excepción, por lo que no se hace nada aquí
        }
    }

    @Test
    public void testConsultarTodasLasMaterias() {
        // Crear varias materias
        Materia materia1 = new Materia(1, "Matemáticas");
        Materia materia2 = new Materia(2, "Historia");
        Materia materia3 = new Materia(3, "Ciencias");

        // Consultar todas las materias existentes
        assertEquals(3, Materia.obtenerTodasLasMaterias().size());
    }

    @Test
    public void testObtenerMateriaPorID() {
        // Crear varias materias
        Materia materia1 = new Materia(1, "Matemáticas");
        Materia materia2 = new Materia(2, "Historia");
        Materia materia3 = new Materia(3, "Ciencias");

        // Consultar una materia por su ID
        Materia materiaConsultada = Materia.obtenerMateriaPorID(2);

        // Verificar que la materia consultada sea la correcta
        assertNotNull(materiaConsultada);
        assertEquals(Integer.valueOf(2), materiaConsultada.getId());
        assertEquals("Historia", materiaConsultada.getNombre());
    }
}
