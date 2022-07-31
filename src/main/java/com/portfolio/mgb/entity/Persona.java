package com.portfolio.mgb.Entity;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona implements Serializable {
    
    /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     
     @NotNull
    @Size(min=1, max=50, message="No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min=1, max=50, message="No cumple con la longitud")
    private String apellido;
     
    
    @Size(min=1, max=500, message="No cumple con la longitud")
    private String img;*/
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
        private Long id;
        private String nombre;
        private String apellido;
        private String titulo;
        @Size(min=1, max=500, message="No cumple con la longitud")
        private String descripcion;
        @Size(min=1, max=500, message="No cumple con la longitud")
        private String img;
    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
        public List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
        private List<Experiencia> experienciaList;
        
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
        private List<Skills> skillsList;
      
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
        private List<Proyectos> proyectosList;
*/
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String titulo, String descripcion, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
       
     
    }

       
    
    
