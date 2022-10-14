
package com.portfolio.mgb.controller;

import com.portfolio.mgb.dto.DtoSkills;
import com.portfolio.mgb.entity.Skills;
import com.portfolio.mgb.security.controller.Mensaje;
import com.portfolio.mgb.service.SeSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "https://frontend-ap-7eeda.web.app")
public class CSkills {
    @Autowired
    SeSkills seSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = seSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!seSkills.existsById(id))
            return new ResponseEntity(new Mensaje("El skill no existe"), HttpStatus.NOT_FOUND);
        Skills skills = seSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!seSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El skill no existe"), HttpStatus.NOT_FOUND);
        }
        seSkills.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills){      
        if(StringUtils.isBlank(dtoSkills.getNameSkill()))
            return new ResponseEntity(new Mensaje("El nombre del skill es obligatorio"), HttpStatus.BAD_REQUEST);
        if(seSkills.existsByNameSkill(dtoSkills.getNameSkill()))
            return new ResponseEntity(new Mensaje("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtoSkills.getNameSkill(), dtoSkills.getPercentSkill());
        seSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("Skill agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills){
        //Validamos si existe el ID
        if(!seSkills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de skills
        if(seSkills.existsByNameSkill(dtoSkills.getNameSkill()) && seSkills.getByNameSkill(dtoSkills.getNameSkill()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoSkills.getNameSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skills skills = seSkills.getOne(id).get();
        skills.setNameSkill(dtoSkills.getNameSkill());
        skills.setPercentSkill((dtoSkills.getPercentSkill()));
        
        seSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
             
    }
}
