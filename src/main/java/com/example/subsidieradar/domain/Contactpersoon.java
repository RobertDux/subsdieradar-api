package com.example.subsidieradar.domain;

import com.example.subsidieradar.domain.exceptions.AlreadyExistsException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contactpersoon implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    String naam;
    String adres;
    String woonplaats;
    String functie;
    String email;
    String wachtwoord;
    int telnr;

    @OneToMany
    List<Organisatie> organisaties = new ArrayList<Organisatie>();

    public Contactpersoon(String naam, String adres, String woonplaats, String functie, String email, int telnr) {
        this.naam = naam;
        this.adres = adres;
        this.woonplaats = woonplaats;
        this.functie = functie;
        this.email = email;
        this.telnr = telnr;
    }

    public Contactpersoon(String email, String wachtwoord) {
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    public Contactpersoon() {
    }

    public void voegOrganisatieToe(Organisatie organisatie) throws AlreadyExistsException {
        if(!organisaties.contains(organisatie)) {
            this.organisaties.add(organisatie);
        } else {
            throw new AlreadyExistsException();
        }
    }
}
