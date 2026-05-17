package vallegrande.edu.pe.mark_alcala.model;

public class Operacion {
    private double numeroUno, numeroDos;

    public Operacion(double numeroUno, double numeroDos) {
        this.numeroDos = numeroDos;
        this.numeroUno = numeroUno;
    }

    public double sumar() {
        return numeroUno + numeroDos;
    }
}