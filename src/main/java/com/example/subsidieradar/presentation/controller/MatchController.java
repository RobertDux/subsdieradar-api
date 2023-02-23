package com.example.subsidieradar.presentation.controller;

import com.example.subsidieradar.application.MatchService;
import com.example.subsidieradar.presentation.dto.InputDTO;
import com.example.subsidieradar.presentation.dto.MatchDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

//    @PostMapping( consumes = { "application/JSON", "application/XML" })
//    public MatchDTO getMatches(@RequestBody InputDTO inputDTO) throws Exception {
//        System.out.println("controller");
//        System.out.println("DTO " + inputDTO.isBijdrage());
//        System.out.println(inputDTO.getSector());
//        return matchService.matchSubsidies(inputDTO);
//    }
    @PostMapping
    public MatchDTO getMatches(@RequestParam String sector,@RequestParam String thema, @RequestParam String typeActiviteit,
                               @RequestParam String budget, @RequestParam String typeAanvrager,
                               @RequestParam String projectlocatie, @RequestParam boolean bijdrage, @RequestParam String samenwerking) throws Exception {
        InputDTO inputDTO = new InputDTO(sector, thema, typeActiviteit, budget, typeAanvrager, projectlocatie,bijdrage, samenwerking);
        return matchService.matchSubsidies(inputDTO);
    }
}
