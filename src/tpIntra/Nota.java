package tpIntra;

public class Nota {
	private TipoExamen tipoDeExamen;
    private Integer valorNota;

    public Nota(TipoExamen tipoDeExamen, Integer valorNota) {
        this.tipoDeExamen = tipoDeExamen;
        this.valorNota = valorNota;
    }

    public TipoExamen getTipoDeExamen() {
        return tipoDeExamen;
    }

    public Integer getValorNota() {  
        return valorNota;
    }
    
    public void setValorNota(Integer valorNota) {
	
    if(valorNota <= 10 && valorNota > 0) {
    	this.valorNota = valorNota;
    }
	}
}
