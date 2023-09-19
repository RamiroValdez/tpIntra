package tpIntra;


public class Aula {
    private String nombre;  // Nombre o número identificador del aula
    private int capacidadMaxima; // Capacidad máxima de alumnos que puede albergar el aula

    public Aula(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Métodos para obtener información del aula
    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
