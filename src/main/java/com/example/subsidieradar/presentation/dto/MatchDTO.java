package com.example.subsidieradar.presentation.dto;

import com.example.subsidieradar.domain.Subsidie;

import java.util.List;

public class MatchDTO {
    public MatchDTO(List<Subsidie> subsidieList) {
        this.subsidieList = subsidieList;
    }
    List<Subsidie> subsidieList;

    public List<Subsidie> getSubsidieList() {
        return subsidieList;
    }
}
