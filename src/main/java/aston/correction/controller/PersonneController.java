package aston.correction.controller;

import aston.correction.entity.Formateur;
import aston.correction.entity.Personne;
import aston.correction.entity.Stagiaire;
import aston.correction.service.PersonneService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Personne findById(@PathVariable Long id){
        return this.personneService.findById(id);
    }

    @GetMapping("nom/{nom}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Personne> findByNom(@PathVariable String nom){
        return this.personneService.findByNom(nom);
    }
    @GetMapping("ville/{ville}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Personne> findAllByVille(@PathVariable String ville){
        return this.personneService.findAllByVille(ville);
    }
    @GetMapping("formateurs/ville/{ville}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Formateur> findAllFormateurByMatiere (@PathVariable String nom){
        return this.personneService.findAllFormateurByMatiere(nom);
    }

    @GetMapping("formateurs")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Formateur> findFormateur(){
        return this.personneService.findFormateur();
    }

    @GetMapping("stagiaires")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Stagiaire> findAllStagiaire(){
        return this.personneService.findAllStagiaire();
    }

    @GetMapping("formateurs/exp/{experience}")
    public List<Formateur> findAllFormateurExperienceGreaterThan( @PathVariable int experience){
        return this.personneService.findAllFormateurExperienceGreaterThan(experience);
    }


    @PostMapping("/stagiaire")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Personne createStagiaire (@RequestBody Stagiaire stagiaire){
        return this.personneService.createStagiaire(stagiaire);
    }
    @PostMapping("/formateur")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Personne createFormateur (@RequestBody Formateur formateur){
        return this.personneService.createFormateur(formateur);
    }




}
