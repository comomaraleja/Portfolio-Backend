
package com.portfolio.mgb.service;

import com.portfolio.mgb.entity.Skills;
import com.portfolio.mgb.repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SeSkills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
        return rSkills.findAll();
    
    }
    public Optional<Skills> getOne(int id) {
        return rSkills.findById(id);
    }
    
    public Optional<Skills> getByNameSkill(String nameSkill){
        return rSkills.findByNameSkill(nameSkill);
    }
    
    public void save (Skills skill){
        rSkills.save(skill);
    }
    
    public void delete (int id){
        rSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }
    
    public boolean existsByNameSkill(String nameSkill){
        return rSkills.existsByNameSkill(nameSkill); 
    }
}
    

