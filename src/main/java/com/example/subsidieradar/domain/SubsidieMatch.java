package com.example.subsidieradar.domain;

import java.io.Serializable;

public class SubsidieMatch implements Serializable {
    Subsidie subsidie;
    int matchPercentage;
    iMatch match;

    public SubsidieMatch(Subsidie subsidie, int matchPercentage, iMatch match) {
        this.subsidie = subsidie;
        this.matchPercentage = matchPercentage;
        this.match = match;
    }
}
