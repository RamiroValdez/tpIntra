package tpIntra;

public class RegistroNotas {

	private Alumno alumno;
	private Nota nota;

	public RegistroNotas(Alumno alumno,Nota nota) {
		this.alumno = alumno;
		this.nota = nota;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	public Nota getNota() {
		return nota;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
}
