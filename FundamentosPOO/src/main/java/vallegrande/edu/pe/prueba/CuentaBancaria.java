package vallegrande.edu.pe.prueba;


public class CuentaBancaria {

    private String titular;
    private double saldo;

    //Constructor

    public CuentaBancaria(String titular, Double saldoInicial){
        this.titular = titular;
        this.saldo = saldoInicial;

    }
    //Método depositar
    public void depositar(double monto){
        if (monto > 0){
            saldo +=monto;
        } else {
            System.out.println("El monto debe ser positivo.");
        }
    }

    //Método retirar
    public void retirar(double monto){
        if(monto <= saldo){
            saldo -= monto;
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }
    //Método mostrarDatos
    public void mostrarDatos(){
        System.out.println("Titular:" + titular);
        System.out.println("Saldo:" + saldo);
    }
}

