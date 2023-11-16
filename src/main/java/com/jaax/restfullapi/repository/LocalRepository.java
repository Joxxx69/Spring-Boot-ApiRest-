package com.jaax.restfullapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jaax.restfullapi.entity.Local;
import java.util.List;


// JpaRepository extiende de otros repositorios (CrudRespository,PageandSortingRepository, etc )
// estos repositorios proveen de metodos para un CRUD
public interface LocalRepository extends JpaRepository<Local,Long> {// entidad: Local y id: long

    
    // Consulta con JPQL, es el lenguaje que maneja Spring Data JPA, para realizar la percistencia a la DB
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findLocalbyNameWithJPQL(String name);

    @Query("SELECT l FROM Local l WHERE l.name like 'A%'")
    List<Local> findLocalsByAWithJPQL();


    //Consulta utilizando IoC Invercion de Control
    Optional<Local> findByName(String name);

    Optional<Local> findByNameIgnoreCase(String name);


} 
