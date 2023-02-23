package com.example.subsidieradar.domain;

import com.example.subsidieradar.domain.enums.Activiteit;
import com.example.subsidieradar.domain.enums.OrganisatieType;
import com.example.subsidieradar.domain.enums.Samenwerking;
import com.example.subsidieradar.domain.exceptions.AlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrganisatieTest {
    public Organisatie organisatie;
    public Project project;

    @BeforeEach
    void initilaize(){
        this.organisatie = new Organisatie("Hogeschool Utrecht", "Onderwijs", "Heidelberglaan 15", "Utrecht", "hu.nl", 34, OrganisatieType.ONDERWIJSINSTELLING);
        this.project = new Project(OrganisatieType.NONPROFIT, "Onderwijs", "ICT", "Utrecht", 200, 20, new Date(), Activiteit.ONDERZOEKONTWIKKELING, Samenwerking.PRIVAATPRIVAAT);
    }

    @Test
    @DisplayName("Project toevoegen lukt")
    void projectToevoegenLukt() {
        organisatie.projecten.add(project);
        assertTrue(organisatie.projecten.contains(project));
    }

    @Test
    @DisplayName("Een bestaand project toevoegen geeft een exception")
    void dubbelProjectToevoegen() throws AlreadyExistsException {
        organisatie.voegProjectToe(project);
        assertThrows(AlreadyExistsException.class, () -> organisatie.voegProjectToe(project));
    }

    @Test
    @DisplayName("Een net aangemaakte organisatie heeft geen projecten")
    void organisatieZonderProjecten() {
        assert(organisatie.projecten.size() == 0);
    }
}