package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import tpIntra.CicloLectivo;
import tpIntra.Comision;
import tpIntra.Materia;
import tpIntra.Profesor;
import tpIntra.Universidad;

public class testDocentes {

	@Test
	public void crearDocente() {
		Profesor nuevoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		
		assertEquals("123456789",nuevoProfesor.getDni());
		assertEquals("Jorge", nuevoProfesor.getNombre());
		assertEquals("Diaz", nuevoProfesor.getApellido());
		assertEquals(LocalDate.of(1985, 5, 11),nuevoProfesor.getFechaNacimiento());
		assertEquals("Programacion Basica II",nuevoProfesor.getMateriaAsignada());
		
	}
	@Test
	public void agregarDocenteAUniversidad() {
		
		Profesor nuevoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		
		Universidad unlam = new Universidad();
		
		assertTrue(unlam.agregarDocentes(nuevoProfesor));
		
	}
	
	@Test
	public void queNoSePuedaAgregarDosProfesoresOMasSiSeRepiteElDNI() {
		
		Profesor nuevoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		Profesor segundoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		Universidad unlam = new Universidad();
		
		unlam.agregarDocentes(nuevoProfesor);
		assertFalse(unlam.agregarDocentes(segundoProfesor));
	}
	
	@Test
	public void asignarUnProfesorAUnaComision() {
		
		Profesor nuevoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		Profesor segundoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		Materia materiaDos = new Materia(2,"Programacion Basica II", null);
		CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),1);
		Comision nuevaComision = new Comision(1,materiaUno,nuevoCiclo,"Noche");
		Universidad unlam = new Universidad();
		
		unlam.agregarMateria(materiaUno);
		unlam.agregarMateria(materiaDos);
		unlam.agregarDocentes(nuevoProfesor);
		unlam.agregarDocentes(segundoProfesor);
		unlam.agregarCicloLectivo(nuevoCiclo);
		unlam.agregarComision(nuevaComision);
		
		
		
		assertTrue(unlam.asignarDocentesAComision(nuevoProfesor, nuevaComision));
		
		Boolean esperado = null;
		for (Comision iterable_element : unlam.getListaComisiones()) {
			esperado = iterable_element.getProfesores().contains(nuevoProfesor);
		}
		
		assertTrue(esperado);
	}
	
	@Test
	public void queNoSePuedaAsignarElMismoProfesorALaMismaComision() {
		
		Profesor nuevoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		Profesor segundoProfesor = new Profesor("123456789","Jorge","Diaz",LocalDate.of(1985, 5, 11),"Programacion Basica II");
		Materia materiaUno = new Materia(1,"Programacion Basica I", null);
		Materia materiaDos = new Materia(2,"Programacion Basica II", null);
		CicloLectivo nuevoCiclo = new CicloLectivo(LocalDate.of(2023,5,16),LocalDate.of(2023,9,2),LocalDate.of(2022,8,16),1);
		Comision nuevaComision = new Comision(1,materiaUno,nuevoCiclo,"Noche");
		Universidad unlam = new Universidad();
		
		unlam.agregarMateria(materiaUno);
		unlam.agregarMateria(materiaDos);
		unlam.agregarDocentes(nuevoProfesor);
		unlam.agregarDocentes(segundoProfesor);
		unlam.agregarCicloLectivo(nuevoCiclo);
		unlam.agregarComision(nuevaComision);
		
		unlam.asignarDocentesAComision(nuevoProfesor, nuevaComision);
		assertFalse(unlam.asignarDocentesAComision(nuevoProfesor, nuevaComision));
		
	}

}
