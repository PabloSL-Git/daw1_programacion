package herencias.ejerciciosUT6.Ej12;

public class CuentaAhorro extends Cuenta {

    private double interes;
    private double comisionAnual;

    public CuentaAhorro(Persona cliente, double interes, double comisionAnual) {
        super(cliente);
        this.interes = interes;
        this.comisionAnual = comisionAnual;
    }

    @Override
    public void retirar(double cantidad) {

        saldo -= cantidad;
    }

    @Override
    public void actualizarSaldo(double cantidad) {

        saldo += cantidad;

        saldo = (saldo + saldo * interes) - comisionAnual;
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo: Cuenta Ahorro";
    }
}
