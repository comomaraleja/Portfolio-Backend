
package com.portfolio.mgb.dto;

import javax.validation.constraints.NotBlank;


public class DtoProyectos {
    
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String imgPro;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombrePro, String descripcionPro, String imgPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripciónPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getImgPro() {
        return imgPro;
    }

    public void setImgPro(String imgPro) {
        this.imgPro = imgPro;
    }
    
    
    
    
}
