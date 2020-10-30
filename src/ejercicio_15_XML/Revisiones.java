package ejercicio_15_XML;

/**
 *
 * @author Gabriel Moreno
 */
public class Revisiones {

    private String filtro;
    private String aceite;
    private String frenos;
    private String otros;
    
    public Revisiones(){
        
    }

    public Revisiones(String filtro, String aceite, String frenos, String otros) {
        this.filtro = filtro;
        this.aceite = aceite;
        this.frenos = frenos;
        this.otros = otros;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public void setAceite(String aceite) {
        this.aceite = aceite;
    }

    public void setFrenos(String frenos) {
        this.frenos = frenos;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getFiltro() {
        return filtro;
    }

    public String getAceite() {
        return aceite;
    }

    public String getFrenos() {
        return frenos;
    }

    public String getOtros() {
        return otros;
    }

}
