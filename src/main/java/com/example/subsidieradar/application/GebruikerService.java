package com.example.subsidieradar.application;

import com.example.subsidieradar.data.GebruikerRepository;
import com.example.subsidieradar.domain.Contactpersoon;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GebruikerService {
    private final GebruikerRepository gebruikerRepository;

    public GebruikerService(GebruikerRepository gebruikerRepository) {
        this.gebruikerRepository = gebruikerRepository;
    }

    public void register(String email, String wachtwoord) {
        Contactpersoon gebruiker = new Contactpersoon(email, wachtwoord);

        this.gebruikerRepository.save(gebruiker);
    }
}
