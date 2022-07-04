package aston.correction.controller;

import aston.correction.entity.Personne;
import aston.correction.service.PersonneService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personnes")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Personne> findAll(){
        return this.personneService.findAll();
    }


}
