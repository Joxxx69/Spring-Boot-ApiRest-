package com.jaax.restfullapi.service;

import java.util.List;
import java.util.Optional;

import com.jaax.restfullapi.entity.Local;
import com.jaax.restfullapi.errors.LocalNotFoundException;

public interface LocalService {
    List<Local> findAllLocals();

    Local saveLocal(Local local);

    Local updateLocal(Long id,Local local);

    void deleteLocal(Long id);

    Optional<Local> findLocalbyNameWithJPQL(String name); // para que me retorne un solo registro

    Optional<Local> findByName(String name);

    Optional<Local> findByNameIgnoreCase(String name);

    Local findLocalById(Long id) throws LocalNotFoundException;
    
    List<Local> findLocalsByA();

}
