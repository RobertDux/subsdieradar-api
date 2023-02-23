package com.example.subsidieradar.domain;

import com.example.subsidieradar.domain.enums.OrganisatieType;
import com.example.subsidieradar.domain.exceptions.AlreadyExistsException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Organisatie implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    String naam;
    String rechtsvorm;
    String adres;
    String vestigingsplaats;
    String website;
    int kvkNummer;
    OrganisatieType organisatieType;

    @OneToMany
    List<Project> projecten = new ArrayList<>();

    public Organisatie(String naam, String rechtsvorm, String adres, String vestigingsplaats, String website, int kvkNummer, OrganisatieType organisatieType) {
        this.naam = naam;
        this.rechtsvorm = rechtsvorm;
        this.adres = adres;
        this.vestigingsplaats = vestigingsplaats;
        this.website = website;
        this.kvkNummer = kvkNummer;
        this.organisatieType = organisatieType;
    }

    public Organisatie() {

    }

    public void voegProjectToe(Project project) throws AlreadyExistsException {
        if(!projecten.contains(project)) {
            this.projecten.add(project);
        } else {
            throw new AlreadyExistsException();
        }
    }

}
