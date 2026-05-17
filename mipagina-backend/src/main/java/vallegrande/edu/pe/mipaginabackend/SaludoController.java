package vallegrande.edu.pe.mipaginabackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class SaludoController{

    @GetMapping("/api/saludo")
    public Map<String, String>enviarSaludo(){
        HashMap<String, String> mapa = new HashMap();
        mapa.put("mensaje","Hola mark el backend en intellij esta funcionando");
        mapa.put("estado","Conectado con exito");
        return mapa;

    }
}