package com.jaax.restfullapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaax.restfullapi.entity.Local;
import com.jaax.restfullapi.errors.LocalNotFoundException;
import com.jaax.restfullapi.repository.LocalRepository;

@Service  // capa de servicio para la logica
public class LocalServiceImplemtation implements LocalService {
    
    @Autowired // inyectar el repositorio automaticamente/ busca un Bean 
    LocalRepository localRepository;// permite que spring maneje las dependencias automaticamente

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }
    
    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }
    @Override
    public Local updateLocal(Long id, Local local) {
        Local localData = localRepository.findById(id).get();
        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            localData.setCode(local.getCode());
        }
        if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            localData.setFloor(local.getFloor());
        }
        if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            localData.setName(local.getName());
        }

        return localRepository.save(localData);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);// hasta mientras no se debe eliminar,
    }

    @Override
    public Optional<Local> findLocalbyNameWithJPQL(String name) {
        return localRepository.findLocalbyNameWithJPQL(name);
    }

    @Override
    public Optional<Local> findByName(String name) {
        return localRepository.findByName(name);
    }

    @Override
    public Optional<Local> findByNameIgnoreCase(String name) {
        return localRepository.findByNameIgnoreCase(name);
    }

    @Override
    /*
      * Es importante tener en cuenta que el uso de get() sin verificar si 
      * el Optional contiene un valor puede provocar una excepción 
      * NoSuchElementException si el Optional está vacío. 
     */
    public Local findLocalById(Long id) throws LocalNotFoundException {
        Optional<Local> local = localRepository.findById(id);
        if (!local.isPresent()) {
            throw new LocalNotFoundException("Local is not available");
        }
        return local.get(); // ocupo get, porque me entrega un optional
    }

    
    @Override
    public List<Local> findLocalsByA() {

        return localRepository.findLocalsByAWithJPQL();
    }



    
    

}
