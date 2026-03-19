package vallegrande.edu.pe.model;

import java.util.Objects;

/**
 * Modelo que representa un contacto en la agenda.
 */
public class Contact {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String direccion;
    private String empresa;
    private String ciudad;
    private String pais;

    public Contact( String id , String name, String email , String phone , String direccion , String empresa , String ciudad , String pais ){
        this.id = id;
        this.name =name;
        this.email =email;
        this.phone =phone;
        this.direccion =direccion;
        this.empresa = empresa;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    //gatters
    public String id(){
        return id;
    }
    public String name(){
        return name;
    }
    public String email(){
        return email;
    }
    public String phone(){
        return phone;
    }
    public String direccion(){
        return  direccion;
    }
    public String empresa(){
        return empresa;
    }
    public String ciudad(){
        return ciudad;
    }
    public String pais(){
        return pais;
    }

    //Setters

    public void setId(String id){
        this.id =id;
    }
    public void setName(String name){
        this.name =name;
    }
    public void setEmail(String email){
        this.email =email;
    }
    public void setPhone(String phone){
        this.phone =phone;
    }
    public void setDireccion(String direccion){
        this.direccion =direccion;
    }
    public void setEmpresa(String empresa){
        this.empresa =empresa;
    }
    public void setCiudad(String ciudad){
        this.ciudad =ciudad;
    }
    public void setPais (String pais){
        this.pais =pais;
    }
    @Override
    public String toString() {
        return String.format("Contact{id='%s', name='%s', email='%s', phone='%s' direccion='%s' empresa='%s' ciudad='%s' pais='%s' }", id, name, email, phone,direccion,empresa,ciudad,pais);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}