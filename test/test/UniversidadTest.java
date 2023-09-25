package test;
import org.junit.Before;
import org.junit.Test;
import tpIntra.Alumno;
import tpIntra.Aula;
import tpIntra.CicloLectivo;
import tpIntra.Comision;
import tpIntra.Materia;
import tpIntra.Nota;
import tpIntra.Profesor;
import tpIntra.RegistroNotas;
import tpIntra.TipoExamen;
import tpIntra.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UniversidadTest {

    private Alumno alumno;	
    private Comision comision;
    private Universidad universidad;
 
    @Before
    public void setUp() {
    	universidad = new Universidad();
        alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");
        comision = new Comision("COM-001");
        
     // Crear instancias de Comision y agregarlas a una lista de comisiones de prueba
        List<Comision> listaComisiones = new ArrayList<>();
        Comision comision1 = new Comision("COM-002");
        Comision comision2 = new Comision("COM-003");
        // Agregar las comisiones a la lista
        listaComisiones.add(comision1);
        listaComisiones.add(comision2);

        // Configurar la listaComisiones en el objeto universidad
        universidad.setListaComisiones(listaComisiones);
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
    
    @Test
    public void registrarNotaDeAlumno() {

        //Primero vamos a colocar todos los datos necesarios para iniciar con el test

         Comision comision = new Comision("COM-001");
         universidad.agregarComision(comision);
         CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,2,12), LocalDate.of(2023, 5, 28), LocalDate.of(2023, 1, 7), LocalDate.of(2023, 1, 15), 1);
         universidad.agregarCicloLectivo(nuevoCiclo);
           Alumno alumno = new Alumno("12345678", "Juan", "Perez", "01/01/1990", "01/01/2023");
           universidad.agregarAlumno(alumno);
           Materia materiaUno = new Materia(1,"Programacion Basica I", null);
         Materia materiaDos = new Materia(2,"Programacion Basica II", null);
          universidad.agregarMateria(materiaUno);
          
      
  			
  			
          universidad.agregarMateria(materiaDos);
           //Ahora vamos a conectar los datos

          
          
           universidad.asignarCicloAComision(comision, nuevoCiclo);
           universidad.agregarCorrelatividad(materiaUno.getId(), 1);
           universidad.asignarMateriaAComision(materiaUno, comision);
 
           //Vamos a crear la clase Nota y la claseRegistroNotas en Comision

           Nota primerNota = new Nota(TipoExamen.PRIMER_PARCIAL, 7);

           assertTrue(universidad.registrarNota(comision,alumno,primerNota));

    }
    
    @Test
    public void testQueNoPuedaRendirUnParcialSiYaRindioConAnterioridad() {
    	
    	 Comision comision = new Comision("COM-001");
         universidad.agregarComision(comision);
         CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,2,12), LocalDate.of(2023, 5, 28), LocalDate.of(2023, 1, 7), LocalDate.of(2023, 1, 15), 1);
         universidad.agregarCicloLectivo(nuevoCiclo);
           Alumno alumno = new Alumno("12345678", "Juan", "Perez", "01/01/1990", "01/01/2023");
           universidad.agregarAlumno(alumno);
           Materia materiaUno = new Materia(1,"Programacion Basica I", null);
         Materia materiaDos = new Materia(2,"Programacion Basica II", null);
          universidad.agregarMateria(materiaUno);
          universidad.agregarMateria(materiaDos);
          Nota primerParcial = new Nota(TipoExamen.PRIMER_PARCIAL,4);
          Nota segundoParcial = new Nota(TipoExamen.SEGUNDO_PARCIAL,10);
          Nota recuPrimerParcial = new Nota(TipoExamen.RECUPERATORIO_P_PARCIAL,7);
           //Ahora vamos a conectar los datos

           universidad.asignarCicloAComision(comision, nuevoCiclo);
           universidad.agregarCorrelatividad(materiaUno.getId(), 1);
           universidad.agregarCorrelatividad(materiaDos.getId(), 1);
           universidad.asignarMateriaAComision(materiaUno, comision);
           universidad.inscribirAlumnoAComision(alumno, comision);
           universidad.registrarNota(comision, alumno, primerParcial);
           universidad.registrarNota(comision, alumno, segundoParcial);
           universidad.registrarNota(comision, alumno, recuPrimerParcial);
           
           // Creamos un cuarto parcial, correspondiente al parcial numero 2, el cual sera erroneo
           Nota parcialErroneo = new Nota(TipoExamen.RECUPERATORIO_S_PARCIAL,7);
           
           assertFalse(universidad.registrarNota(comision, alumno, parcialErroneo));

    	
    }
    
    @Test
    public void testQueNoPuedaAgregarUnaNotaMayorA10oMenorA1() {
    	
    	 Comision comision = new Comision("COM-001");
         universidad.agregarComision(comision);
         CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,2,12), LocalDate.of(2023, 5, 28), LocalDate.of(2023, 1, 7), LocalDate.of(2023, 1, 15), 1);
         universidad.agregarCicloLectivo(nuevoCiclo);
           Alumno alumno = new Alumno("12345678", "Juan", "Perez", "01/01/1990", "01/01/2023");
           universidad.agregarAlumno(alumno);
           Materia materiaUno = new Materia(1,"Programacion Basica I", null);
         Materia materiaDos = new Materia(2,"Programacion Basica II", null);
          universidad.agregarMateria(materiaUno);
          universidad.agregarMateria(materiaDos);
          Nota primerParcial = new Nota(TipoExamen.PRIMER_PARCIAL,-1);
          Nota segundoParcial = new Nota(TipoExamen.SEGUNDO_PARCIAL,11);

           //Ahora vamos a conectar los datos

           universidad.asignarCicloAComision(comision, nuevoCiclo);
           universidad.agregarCorrelatividad(materiaUno.getId(), 1);
           universidad.agregarCorrelatividad(materiaDos.getId(), 1);
           universidad.asignarMateriaAComision(materiaUno, comision);
           universidad.inscribirAlumnoAComision(alumno, comision);
          
           
           //Trataremos de registrar notas fuera del rango posible
           
           assertFalse(universidad.registrarNota(comision, alumno, primerParcial));
           assertFalse(universidad.registrarNota(comision, alumno, segundoParcial));
 
    	
    }
    
    @Test
    public void testQueNoPuedaAgregarUnaNotaMayorA7SiNoTieneCorrelativaAprobada() {
    	
    	 Comision comision = new Comision("COM-001");
         universidad.agregarComision(comision);
         CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,2,12), LocalDate.of(2023, 5, 28), LocalDate.of(2023, 1, 7), LocalDate.of(2023, 1, 15), 1);
         universidad.agregarCicloLectivo(nuevoCiclo);
           Alumno alumno = new Alumno("12345678", "Juan", "Perez", "01/01/1990", "01/01/2023");
           universidad.agregarAlumno(alumno);
           Materia materiaUno = new Materia(1,"Programacion Basica I", null);
         Materia materiaDos = new Materia(2,"Programacion Basica II", null);
          universidad.agregarMateria(materiaUno);
          universidad.agregarMateria(materiaDos);
          Nota primerParcial = new Nota(TipoExamen.PRIMER_PARCIAL,10);
          Nota segundoParcial = new Nota(TipoExamen.SEGUNDO_PARCIAL,10);
          Nota finals = new Nota(TipoExamen.FINAL,10);

           //Ahora vamos a conectar los datos

           universidad.asignarCicloAComision(comision, nuevoCiclo);
           universidad.agregarCorrelatividad(materiaUno.getId(), 1);
           universidad.agregarCorrelatividad(materiaDos.getId(), 1);
           universidad.asignarMateriaAComision(materiaDos, comision);
           universidad.inscribirAlumnoAComision(alumno, comision);
           universidad.registrarNota(comision, alumno, primerParcial);
           universidad.registrarNota(comision, alumno, segundoParcial);
           
           
           //Trataremos de registrar notas fuera del rango posible
           
           assertFalse(universidad.registrarNota(comision, alumno, finals));
 
    	
    }
    
    
    @Test
    public void testObtenerNota() {
        Alumno alumno = new Alumno("12345678", "Juan", "Perez", "01/01/1990", "01/01/2023");
        Materia materia = new Materia(1, "Programacion Basica I", null);
        Universidad universidad = new Universidad();

        Comision comision = new Comision("COM-115");

        comision.agregarAlumno(alumno);
        comision.setMateria(materia);
        
        universidad.agregarAlumno(alumno);
        universidad.agregarMateria(materia);

        RegistroNotas registro = new RegistroNotas(alumno, new Nota(TipoExamen.PRIMER_PARCIAL, 7));
        comision.agregarRegistroNotas(registro);
        
        universidad.agregarComision(comision);

        Nota notaObtenida = universidad.obtenerNota(alumno, materia);

        assertNotNull("La nota obtenida es nula", notaObtenida);
        assertEquals("El tipo de examen no coincide", TipoExamen.PRIMER_PARCIAL, notaObtenida.getTipoDeExamen());
        assertEquals("El valor de la nota no coincide", Integer.valueOf(7), notaObtenida.getValorNota()); 
    }

    @Test
    public void testCalcularPromedio() {
        // Crear una instancia de Universidad
        Universidad universidad = new Universidad();

        // Crear instancias de Alumnos, Comisiones, Materias y registros de notas para pruebas
        Alumno alumno1 = new Alumno("115", "Juan", "Perez", "01/01/1990", "01/09/2023");
        Alumno alumno2 = new Alumno("987654321", "Ana", "Gomez", "15/03/1995", "01/09/2023");
        Comision comision1 = new Comision("COM-001");
        Comision comision2 = new Comision("COM-002");
        Materia materia = new Materia(1, "Programacion Basica I", null);
        CicloLectivo cicloLectivo = new CicloLectivo(LocalDate.now(), LocalDate.now().plusMonths(4), LocalDate.now().minusMonths(1), LocalDate.now().plusDays(7), 1);
        RegistroNotas registro1 = new RegistroNotas(alumno1, new Nota(TipoExamen.PRIMER_PARCIAL, 7));
        RegistroNotas registro2 = new RegistroNotas(alumno1, new Nota(TipoExamen.SEGUNDO_PARCIAL, 8));
        RegistroNotas registro3 = new RegistroNotas(alumno2, new Nota(TipoExamen.PRIMER_PARCIAL, 6));

        // Agregar alumnos, comisiones, materias, ciclo lectivo y registros de notas a la universidad
        universidad.agregarAlumno(alumno1);
        universidad.agregarAlumno(alumno2);
        universidad.agregarComision(comision1);
        universidad.agregarComision(comision2); 
        universidad.agregarMateria(materia);
        universidad.agregarCicloLectivo(cicloLectivo);
        universidad.asignarCicloAComision(comision1, cicloLectivo);
        universidad.asignarCicloAComision(comision2, cicloLectivo);
        universidad.asignarMateriaAComision(materia, comision1);
        universidad.inscribirAlumnoAComision(alumno1, comision1);
        
        // Agregar registros de notas a las comisiones
        comision1.agregarRegistroNotas(registro1);
        comision1.agregarRegistroNotas(registro2);
        comision2.agregarRegistroNotas(registro3);
        
        // Calcular el promedio de notas del alumno con DNI "123456789"
        double promedio = universidad.calcularPromedio("115");

        // El promedio esperado es (7 + 8) / 2 = 7.5
        assertEquals(7.5, promedio, 0.01); // Usamos un delta pequeño para manejar posibles errores de redondeo
    }

    
    @Test
    public void testObtenerListasMateriasQueFaltanCursar() {
    	
    	   Alumno alumno = new Alumno("12345678", "Juan", "Perez", "01/01/1990", "01/01/2023");
           
    	   Materia materia = new Materia(1, "Programacion Basica I", null);
           Materia materiaDos = new Materia(2,"Programacion Basica II", null);
           Comision comision = new Comision("COM-115");
           CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,2,12), LocalDate.of(2023, 5, 28), LocalDate.of(2023, 1, 7), LocalDate.of(2023, 1, 15), 1);
       	
           Universidad universidad = new Universidad();

           universidad.agregarAlumno(alumno);
           universidad.agregarMateria(materia);
           universidad.agregarMateria(materiaDos);
           universidad.agregarComision(comision);
           
           universidad.asignarMateriaAComision(materia, comision);
           universidad.asignarCicloAComision(comision, nuevoCiclo);
           universidad.inscribirAlumnoAComision(alumno, comision);
           universidad.registrarNota(comision, alumno, new Nota(TipoExamen.PRIMER_PARCIAL,10));
           universidad.registrarNota(comision, alumno, new Nota(TipoExamen.SEGUNDO_PARCIAL,10));
           universidad.registrarNota(comision, alumno, new Nota(TipoExamen.FINAL,10));
           
           for (Alumno a : universidad.getListaAlumnos()) {
			if(a.getDni().equals(alumno.getDni())) {
				a.aprobarMateria(materia);
			}
			
			assertEquals(1,universidad.obtenerMateriasQueLeFaltanCursarAUnAlumno(alumno).size());
			assertTrue(universidad.obtenerMateriasQueLeFaltanCursarAUnAlumno(alumno).contains(materiaDos));
		}
    	
    	
    	
    }
    
    @Test
    public void testAgregarConsultarCorrelativasAprobadas() {
        Alumno alumno = new Alumno("123456789", "Juan", "Perez", "01/01/1990", "01/09/2023");

        // Agregar correlativas aprobadas
        Materia correlativa1 = new Materia(1, "Correlativa1",2);
        Materia correlativa2 = new Materia(2, "Correlativa2",3);
        Materia correlativa3 = new Materia(3, "Correlativa2",null);
        
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
        universidad.agregarAlumno(alumno);
        // Simular que el alumno tiene al menos 4 correlativas aprobadas
        for (int i = 1; i <= 4; i++) {
            Materia correlativaAprobada = new Materia(i, "Materia" + i, i);
            alumno.agregarCorrelativaAprobada(correlativaAprobada);
        }

        // Intentar inscribir al alumno en una comisión con al menos 4 correlativas aprobadas (debería ser exitoso)
        assertTrue(universidad.inscribirAlumnoAComision(alumno, comision));
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
