package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contact;
import vallegrande.edu.pe.model.ContactRepository;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que maneja la lógica entre la vista y el modelo.
 */
public class ContactController {
private final ContactRepository repo;
public ContactController(ContactRepository repo){
    this.repo=repo;
}
    public Contact create(String id,String name,String email,String phone,String direccion,String empresa,String ciudad,String pais){
    Contact c =new Contact(id , name , email , phone,direccion,empresa,ciudad,pais);
    return repo.save(c);
    }

    public Optional<Contact> get(String id){
    return repo.findById(Long.parseLong(id));

    }
    public List<Contact> list(){
    return repo.findAll();
    }
    public boolean delete(String id) {
    return repo.deleteById(id);
    }
}