package com.example.subsidieradar.domain;


import com.example.subsidieradar.domain.enums.Activiteit;
import com.example.subsidieradar.domain.enums.OrganisatieType;
import com.example.subsidieradar.domain.enums.Samenwerking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    OrganisatieType organisatieType;
    String sector;
    String thema;
    String projectlocatie;
    int minSubsidieBedrag;
    int minSubsidiePercentage;
    Date startdatum;
    Activiteit activiteit;
    Samenwerking samenwerking;

    public Project(OrganisatieType organisatieType, String sector, String thema,
                   String projectlocatie, int minSubsidieBedrag, int minSubsidiePercentage,
                   Date startdatum, Activiteit activiteit, Samenwerking samenwerking) {
        this.organisatieType = organisatieType;
        this.sector = sector;
        this.thema = thema;
        this.projectlocatie = projectlocatie;
        this.minSubsidieBedrag = minSubsidieBedrag;
        this.minSubsidiePercentage = minSubsidiePercentage;
        this.startdatum = startdatum;
        this.activiteit = activiteit;
        this.samenwerking = samenwerking;
    }

    public Project() {

    }
}
