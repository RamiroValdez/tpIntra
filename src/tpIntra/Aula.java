package tpIntra;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Aula otraAula = (Aula) obj;
        return capacidadMaxima == otraAula.capacidadMaxima && Objects.equals(nombre, otraAula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, capacidadMaxima);
    }

}
