
package com.portfolio.mgb.security.service;

import com.portfolio.mgb.security.entity.Rol;
import com.portfolio.mgb.security.enums.RolNombre;
import com.portfolio.mgb.security.repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
   @Autowired 
   iRolRepository iRolRepository;
   
   public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return iRolRepository.findByRolNombre(rolNombre);
   }
   
   public void save(Rol rol){
       iRolRepository.save(rol); //dejar this está bien tambien, pues está haciendo referencia a la variable local.
   }
}  
