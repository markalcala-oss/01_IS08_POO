package vallegrande.edu.pe.mark_alcala.model;

public class Operacion {

    private double numero1;
    private double numero2;


    public Operacion(double numeroUno, double numeroDos) {
        this.numero1 = numeroUno;
        this.numero2 = numeroDos;
    }

    public double sumar() {
        return this.numero1 + this.numero2;
    }
}
