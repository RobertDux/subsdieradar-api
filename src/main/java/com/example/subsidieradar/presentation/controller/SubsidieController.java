package com.example.subsidieradar.presentation.controller;

import com.example.subsidieradar.application.SubsidieService;
import com.example.subsidieradar.domain.Subsidie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/subsidie")
public class SubsidieController {
    private final SubsidieService subsidieService;

    public SubsidieController(SubsidieService subsidieService) {
        this.subsidieService = subsidieService;
    }

    @GetMapping
    public List<Subsidie> getSubsidies() throws Exception {
        return subsidieService.getSubsidies();
    }

    @GetMapping("/{subsidie}")
    public Subsidie getSubsidie(@PathVariable String subsidie) throws Exception {
        return subsidieService.getSubsidie(subsidie);
    }
}
