package com.example.subsidieradar.presentation.controller;

import com.example.subsidieradar.application.GebruikerService;
import com.example.subsidieradar.presentation.dto.RegistratieDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class GebruikerController {
    private final GebruikerService gebruikerService;

    public GebruikerController(GebruikerService gebruikerService) {
        this.gebruikerService = gebruikerService;
    }

    @PostMapping
    void register(@Validated @RequestBody RegistratieDTO registratie) {
        this.gebruikerService.register(
                registratie.email,
                registratie.wachtwoord);
    }
}
