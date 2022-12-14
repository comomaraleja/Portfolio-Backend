 
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Entity.Persona;
import com.portfolio.mgb.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.RequestMapping;*/
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@RequestMapping("/personas")*/
@CrossOrigin(origins = "https://frontend-ap-7eeda.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    //Decirle al Front qué mostrar
    
    //EL USUARIO SÓLO VA A PODER VER
    @GetMapping("/personas/traer") //Es para que pase de la base de datos al Front
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    /*@PreAuthorize("hasRole('ADMIN')")*/ //LÍNEA QUE INDICA QUE SOLO EL ADMINISTRADOR PUEDE HACER EL CRUD
    @PostMapping("/personas/crear") //es el caso inverso: desde el front se guarda en la base de datos
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona); 
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
        public String deletePersona(@PathVariable Long id) {
            ipersonaService.deletePersona(id);
            return "La persona fue eliminada correctamente";
        }
    
    //URL:PUERTO/personas/editar/id/nombre & apellido & img 
    @PreAuthorize("hasRole('ADMIN')")    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre, 
                               @RequestParam("apellido") String nuevoApellido, 
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("descripcion") String nuevaDescripcion,
                               @RequestParam("img") String nuevoImg
                               
    
    ) {
       
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setTitulo(nuevoTitulo);
        persona.setDescripcion(nuevaDescripcion);
        persona.setImg(nuevoImg);
        
      
        
        ipersonaService.savePersona(persona);
        return persona;
                                
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
    return ipersonaService.findPersona((long) 1);
    }
}
    
    
        
    
    


