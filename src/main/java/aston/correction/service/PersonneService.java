package aston.correction.service;

import aston.correction.entity.Personne;
import aston.correction.repository.PersonneRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    private PersonneRepo personneRepo;
    public List<Personne> findAll() {
        return this.personneRepo.findAll();
    }
}
