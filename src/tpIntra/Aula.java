package tpIntra;


public class Aula {
    
	private String nombre;
    private int capacidadMaxima;

    public Aula(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public void setCapacidadMaxima(int i) {
        this.capacidadMaxima = i;
    }

}
