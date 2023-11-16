package com.jaax.restfullapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaax.restfullapi.entity.Local;
import com.jaax.restfullapi.errors.LocalNotFoundException;
import com.jaax.restfullapi.service.LocalService;

import jakarta.validation.Valid;

@Validated
@RestController
public class LocalController {
    
    @Autowired
    LocalService localService;

    @GetMapping("/findAllLocals")
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    @PostMapping("/saveLocal")
    public Local saveLocal(@Valid @RequestBody Local local) {
        return localService.saveLocal(local);

    }

    @PutMapping("/updateLocal/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local,
            @RequestParam(value = "name", defaultValue = "cell") String name) {
        System.out.println(name);
        return localService.updateLocal(id, local);
    }
    @DeleteMapping("/deleteLocal/{id}")
    public String deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
        return "Succesfully delete";
    }

    @GetMapping("/findLocalByNameWithJPQL/{name}")
    Optional<Local> findLocalByNameWithJPQL(@PathVariable String name) {
        return localService.findLocalbyNameWithJPQL(name);
    }
    @GetMapping("/findByName/{name}")
    Optional<Local> findByName(@PathVariable String name) {
        return localService.findByName(name);
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    Optional<Local> findByNameIgnoreCase(@PathVariable String name) {
        return localService.findByNameIgnoreCase(name);

    }
    
    @GetMapping("/findLocalById/{id}")
    Local findLocalById(@PathVariable Long id) throws LocalNotFoundException {

        return localService.findLocalById(id);
    }
    
    @GetMapping("/findLocalsByA")
    public List<Local> findLocalByA() {
        
        return localService.findLocalsByA();
    }
}
