package ejerciciosUT6.Ej12;

public abstract class Cuenta {

    protected String numeroCuenta;
    protected double saldo;
    protected Persona cliente;

    private static int contador = 1000000000;

    public Cuenta(Persona cliente) {
        this.cliente = cliente;
        this.saldo = 0;
        this.numeroCuenta = String.valueOf(contador++);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void actualizarSaldo(double cantidad) {
        saldo += cantidad;
    }

    public abstract void retirar(double cantidad);

    @Override
    public String toString() {
        return "Cuenta: " + numeroCuenta +
                " Cliente: " + cliente +
                " Saldo: " + saldo;
    }
}
