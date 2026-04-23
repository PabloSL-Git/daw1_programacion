
package ficherosjson;

import java.util.List;

/**
 *
 * @author Vico
 * Clase POJO (Plain Old Java Object) que representa un envío de muebles. 
 * Se usará para escribir y leer objetos de tipo EnvioMuebles en formato JSON
 */


public class EnvioMuebles {
    
    private long id;
    private String direccionEnvio;
    private String nombreCliente;
    private List<Mueble> catalogo;
    
    public EnvioMuebles(){
        
    }

    public EnvioMuebles(long id, String direccionEnvio, String nombreCliente, List<Mueble> catalogo) {
        this.id = id;
        this.direccionEnvio = direccionEnvio;
        this.nombreCliente = nombreCliente;
        this.catalogo = catalogo;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<Mueble> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Mueble> catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        StringBuilder txt= new StringBuilder();
        catalogo.forEach(muebleVO -> {
            txt.append("\n").append(muebleVO.toString());
        });
        return "EnvioMuebles{" + "id=" + id + ", direccionEnvio=" + direccionEnvio + ", nombreCliente=" + nombreCliente + ",\n"
                + " catalogo=" + txt + '}';
    }
    
    
    
}
