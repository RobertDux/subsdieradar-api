package com.example.subsidieradar.domain;

import com.example.subsidieradar.domain.enums.OrganisatieType;
import com.example.subsidieradar.domain.exceptions.AlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactpersoonTest {
    public Contactpersoon persoon;
    public Organisatie organisatie;

    @BeforeEach
    void initilaize(){
        this.persoon = new Contactpersoon("Ayoub", "Clownstraat 69", "Gouda", "Student", "kelly@student.hu.nl", 646136136);
        this.organisatie = new Organisatie("Hogeschool Utrecht", "Onderwijs", "Heidelberglaan 15", "Utrecht", "hu.nl", 34, OrganisatieType.ONDERWIJSINSTELLING);
    }

    @Test
    @DisplayName("Organisatie toevoegen lukt")
    void organisatieToevoegenLukt() throws AlreadyExistsException {
        persoon.voegOrganisatieToe(organisatie);
        assertTrue(persoon.organisaties.contains(organisatie));
    }

    @Test
    @DisplayName("Een bestaande organisatie toevoegen geeft een exception")
    void dubbelOrganisatieToevoegen() throws AlreadyExistsException {
        persoon.voegOrganisatieToe(organisatie);
        assertThrows(AlreadyExistsException.class, () -> persoon.voegOrganisatieToe(organisatie));
    }

    @Test
    @DisplayName("Een net aangemaakt persoon heeft geen organisaties")
    void persoonZonderOrganisaties() {
        assert(persoon.organisaties.size() == 0);
    }
}