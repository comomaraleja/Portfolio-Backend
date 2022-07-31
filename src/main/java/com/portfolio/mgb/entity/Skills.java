
package com.portfolio.mgb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Size(min=1, max=50, message="No cumple con la longitud")
    private String nameSkill;
    
    @Size(min=1, max=5, message="Debe introducir una cantidad entre 0-100")
    private String percentSkill;

    public Skills() {
    }

    public Skills(String nameSkill, String percentSkill) {
        this.nameSkill = nameSkill;
        this.percentSkill = percentSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public String getPercentSkill() {
        return percentSkill;
    }

    public void setPercentSkill(String percentSkill) {
        this.percentSkill = percentSkill;
    }
    
    
    
    
    
}
