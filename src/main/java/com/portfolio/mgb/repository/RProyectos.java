
package com.portfolio.mgb.repository;

import com.portfolio.mgb.entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);
    
}
