package ejemplos_profesor.ejemplo2;

/*
Una clase es un molde para crear objetos
Tiene atributos y métodos
Encapsula información relacionada
 */
// Declaración -> public class Nombre
public class Venta {

    // Atributos de instancia - privados
    // Los atributos se inicializan con null (objetos), 0 números,
    // false booleanos como valores por defecto
    private String nombreProductor;
    private String tamanioAceituna;
    private String tipoAceituna;
    private double kg;
    private double precioVenta;

    // Métodos de instancia
    // Constructor
    // Permite inicilizar los atributos de un objeto
    // El constructor siempre se llama igual que la clase
    // Nunca especifican dato de retorno
    // Pasamos como parámetro los valores que queremos poner al objeto

    public Venta(String nombre, String tamanioAceituna, String tipoAceituna, double kg, double precioVenta) {
        nombreProductor = nombre;
        this.tamanioAceituna = tamanioAceituna;
        this.tipoAceituna = tipoAceituna;
        this.kg = kg;
        this.precioVenta = precioVenta;
    }

    public String getNombreProductor() {
        return nombreProductor;
    }

    public void setNombreProductor(String nombreProductor) {
        this.nombreProductor = nombreProductor;
    }

    public String getTamanioAceituna() {
        return tamanioAceituna;
    }

    public void setTamanioAceituna(String tamanioAceituna) {
        this.tamanioAceituna = tamanioAceituna;
    }

    public String getTipoAceituna() {
        return tipoAceituna;
    }

    public void setTipoAceituna(String tipoAceituna) {
        this.tipoAceituna = tipoAceituna;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    // Anotación informativa de sobrescritura de método
    @Override
    public String toString() {
        return "Venta {nombreProductor=" + nombreProductor + ", tamanioAceituna=" + tamanioAceituna + ", tipoAceituna="
                + tipoAceituna + ", kg=" + kg + ", precioVenta=" + precioVenta + "}";
    }

}