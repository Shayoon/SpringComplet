package aston.correction.service;

import aston.correction.entity.Formateur;
import aston.correction.entity.Personne;
import aston.correction.entity.Stagiaire;
import aston.correction.repository.PersonneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepo personneRepo;
    public List<Personne> findAll() {
        return this.personneRepo.findAll();
    }


    public Personne findById(Long id) {
        Optional<Personne> optionalPersonne = this.personneRepo.findById(id);
        if (optionalPersonne.isPresent()) {
            return optionalPersonne.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Personne createFormateur(Formateur formateur) {
        return this.personneRepo.save(formateur);
    }

    public Personne createStagiaire(Stagiaire stagiaire) {
        return this.personneRepo.save(stagiaire);
    }

    public List<Personne> findByNom(String nom) {
        return this.personneRepo.findByNom(nom);
    }

    public List<Personne> findAllByVille(String ville) {
        return this.personneRepo.findAllByVille(ville);
    }

    public List<Formateur> findAllFormateurByMatiere(String nom) {
        return this.personneRepo.findAllFormateurByMatiere(nom);
    }


    public List<Formateur> findFormateur() {
        return this.personneRepo.findFormateur();
    }


    public List<Stagiaire> findAllStagiaire() {
        return this.personneRepo.findAllStagiaire();
    }


    public List<Formateur> findAllFormateurExperienceGreaterThan(int experience) {
        return this.personneRepo.findAllFormateurExperienceGreaterThan(experience);
    }
}
