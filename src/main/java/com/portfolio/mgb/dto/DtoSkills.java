
package com.portfolio.mgb.dto;

import javax.validation.constraints.NotBlank;


public class DtoSkills {
   
   @NotBlank 
   private String nameSkill;
   @NotBlank
   private String percentSkill;

    public DtoSkills() {
    }

    public DtoSkills(String nameSkill, String percentSkill) {
        this.nameSkill = nameSkill;
        this.percentSkill = percentSkill;
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
