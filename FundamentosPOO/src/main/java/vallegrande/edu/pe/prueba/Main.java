package vallegrande.edu.pe.prueba;


public class Main {

 public static void main ( String [] args){

  CuentaBancaria cuenta1 = new CuentaBancaria("Luis", 1000.0);
  cuenta1.depositar(500);
  cuenta1.retirar(300);
  cuenta1.mostrarDatos();

 }

 }
