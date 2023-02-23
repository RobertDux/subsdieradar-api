package com.example.subsidieradar.domain;

import java.util.List;

public interface iMatch {
    List<Subsidie> findMatches(List<Subsidie> subsidies,
                               String sector,
                               String thema,
                               String typeActiviteit,
                               String budget,
                               String typeAanvrager,
                               String projectlocatie,
                               boolean bijdrage,
                               String samenwerking);
}
