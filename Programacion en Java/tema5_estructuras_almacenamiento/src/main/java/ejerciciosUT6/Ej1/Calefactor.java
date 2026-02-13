package ejerciciosUT6.Ej1;

public class Calefactor {
    private Integer tmp;
    private boolean estado;

    public Calefactor(Integer tmp, boolean estado) {
        this.tmp = tmp;
        this.estado = estado;
    }
    public Integer getTmp() {
        return tmp;
    }
    public void setTmp(Integer tmp) {
        this.tmp = tmp;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Calefactor [tmp=" + tmp + ", estado=" + estado + "]";
    }

    
}
