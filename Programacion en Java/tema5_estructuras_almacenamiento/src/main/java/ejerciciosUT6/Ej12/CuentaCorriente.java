package ejerciciosUT6.Ej12;

public class CuentaCorriente extends Cuenta {

    private double interes = 0.015;
    private double saldoMin;

    public CuentaCorriente(Persona cliente, double saldoMin) {
        super(cliente);
        this.saldoMin = saldoMin;
    }

    @Override
    public void retirar(double cantidad) {

        if ((saldo - cantidad) >= saldoMin) {
            saldo -= cantidad;
        } else {
            System.out.println("No se puede retirar. Saldo mínimo alcanzado.");
        }
    }

    @Override
    public void actualizarSaldo(double cantidad) {

        saldo += cantidad;

        if (saldo > 1000) {
            saldo += saldo * interes;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo: Cuenta Corriente";
    }
}
