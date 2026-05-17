package vallegrande.edu.pe.model;

public class Plato {
    private int id;
    private String nombre;
    private double precio;
    private String categoria;

    // Constructor vacío
    public Plato() {}

    // Constructor con datos
    public Plato(int id, String nombre, double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters y Setters (Necesarios para que el CRUD lea los datos)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
