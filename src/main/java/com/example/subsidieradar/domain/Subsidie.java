package com.example.subsidieradar.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Subsidie implements Serializable {

    @Id
    public String naam;
    String afkortingen;
    String niveau;
    String subsidieverstrekker;
    @Column(length = 999)
    String doel;
    String sector;
    String themas;
    @Column(length = 999)
    String thema_verdieping;
    @Column(length = 999)
    String subsidiabele_activiteiten;
    @Column(length = 999)
    String subsidiabele_activiteiten_output;
    String locatie;
    String soort_organisatie;
    @Column(length = 999)
    String soort_organisatie_output;
    String samenwerking;
    String samenwerking_matching;
    String type_samenwerking;
    double totaal_budget;
    double subsidiebedrag;
    String bijzonderheid;
    String subsidiepercentage;
    String datum_open;
    String datum_sluit;
    String beoordeling_tender;
    String looptijdProject; //was eerst jaren
    @Transient
    int matchingPercentage;
    @Transient
    Boolean knockout;

    public Subsidie(String naam, String afkortingen, String niveau, String subsidieverstrekker, String doel,
                    String themas, String subsidiabele_activiteiten, String locatie, String soort_organisatie,
                    String soort_organisatie_output,
                    String samenwerking, String type_samenwerking, double totaal_budget, double subsidiebedrag,
                    String bijzonderheid, String subsidiepercentage,
                    String datum_open, String datum_sluit, String beoordeling_tender,
                    String looptijdProject,
                    String samenwerking_matching) {
        this.naam = naam;
        this.afkortingen = afkortingen;
        this.niveau = niveau;
        this.subsidieverstrekker = subsidieverstrekker;
        this.doel = doel;
        this.themas = themas;
        this.subsidiabele_activiteiten = subsidiabele_activiteiten;
        this.locatie = locatie;
        this.soort_organisatie = soort_organisatie;
        this.soort_organisatie_output = soort_organisatie_output;
        this.samenwerking = samenwerking;
        this.type_samenwerking = type_samenwerking;
        this.totaal_budget = totaal_budget;
        this.subsidiebedrag = subsidiebedrag;
        this.bijzonderheid = bijzonderheid;
        this.subsidiepercentage = subsidiepercentage;
        this.datum_open = datum_open;
        this.datum_sluit = datum_sluit;
        this.beoordeling_tender = beoordeling_tender;
        this.looptijdProject = looptijdProject;
        this.samenwerking_matching = samenwerking_matching;

        this.knockout = false;
//        this.matchingPercentage = null;
    }

    public Subsidie() {

    }

//    public Long getId() {
//        return id;
//    }

    public String getNaam() {
        return naam;
    }
    public int getMatchingPercentage() {
        return matchingPercentage;
    }

    public Boolean getKnockout() {
        return knockout;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getAfkortingen() {
        return afkortingen;
    }

    public String getSubsidieverstrekker() {
        return subsidieverstrekker;
    }

    public String getDoel() {
        return doel;
    }

    public String getThemas() {
        return themas;
    }

    public String getSubsidiabele_activiteiten() {
        return subsidiabele_activiteiten;
    }

    public String getLocatie() {
        return locatie;
    }

    public String getSoort_organisatie() {
        return soort_organisatie;
    }

    public String getSamenwerking() {
        return samenwerking;
    }

    public String getType_samenwerking() {
        return type_samenwerking;
    }

    public double getTotaal_budget() {
        return totaal_budget;
    }

    public String getBijzonderheid() {
        return bijzonderheid;
    }

    public String getDatum_open() {
        return datum_open;
    }

    public String getDatum_sluit() {
        return datum_sluit;
    }

    public String getBeoordeling_tender() {
        return beoordeling_tender;
    }

    public void setMatchingPercentage(int matchingPercentage) {
        this.matchingPercentage = matchingPercentage;
    }
    public void setKnockout(boolean knockout){
        this.knockout = knockout;
    }

    public String getSector() {
        return sector;
    }

    public String getThema_verdieping() {
        return thema_verdieping;
    }

    public String getSubsidiabele_activiteiten_output() {
        return subsidiabele_activiteiten_output;
    }

    public double getSubsidiebedrag() {
        return subsidiebedrag;
    }

    public String getSubsidiepercentage() {
        return subsidiepercentage;
    }

    public String getLooptijdProject() {
        return looptijdProject;
    }
}
