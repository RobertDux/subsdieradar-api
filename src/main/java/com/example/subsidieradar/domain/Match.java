package com.example.subsidieradar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Match implements iMatch {
    @Override
    public List<Subsidie> findMatches(List<Subsidie> subsidies,
                                    String sector,
                                    String thema,
                                    String typeActiviteit,
                                    String budget,
                                    String typeAanvrager,
                                    String projectlocatie,
                                    boolean bijdrage,
                                    String samenwerking) {
        List<Subsidie> filteredSubsidies = new ArrayList<>();

        for (Subsidie subsidie : subsidies) {
            //eerst checken we of er knockoutcriteria zijn
            subsidie.setKnockout(false);

            System.out.println(subsidie.getAfkortingen());

            if (!subsidie.getNiveau().toLowerCase().contains(projectlocatie.substring(1, projectlocatie.length() -1).toLowerCase())){
                subsidie.setKnockout(true);
            }

            if (!subsidie.getSoort_organisatie().toLowerCase().contains(typeAanvrager.substring(1, typeAanvrager.length() -1).toLowerCase())){
                subsidie.setKnockout(true);
            }

            if (!subsidie.getSector().equals("Geen vereiste")){
                if (!subsidie.getSector().toLowerCase().contains(sector.substring(1, sector.length() -1).toLowerCase())){
                    subsidie.setKnockout(true);
                }
            }


            // dan checken we groep 1; 65 punten; thema, activiteiten
            int percentageGroep1 = 65;
            if (!subsidie.getThemas().toLowerCase().contains(thema.substring(1, thema.length() -1).toLowerCase())) {    // als subsidie ander thema heeft -35%
                percentageGroep1 = percentageGroep1 - 35;
                System.out.println(subsidie.getThemas().toLowerCase());
                System.out.println(thema.toLowerCase());
                System.out.println("-35");
            }
            if (!subsidie.getSubsidiabele_activiteiten().toLowerCase().contains(typeActiviteit.substring(1, typeActiviteit.length() -1).toLowerCase())) {
                percentageGroep1 = percentageGroep1 - 30;
                System.out.println("-30");
            }

            // dan groep 2; 35 punten; Verplicht; Minimaal benodigd subsidiebedrag, beoogde startdatum
            // niet verplicht;, cofinanciering mogelijkheid
            int percentageGroep2 = 35;

            //budget
            double gegevenBudget = Double.parseDouble(budget.substring( 1, budget.length() - 1 ));
            boolean cat1 = false;
            boolean cat2 = false;
            boolean cat3 = false;
            boolean cat4 = false;

            if (subsidie.getSubsidiebedrag() < 50000){
                cat1 = true;
            } else if (subsidie.getSubsidiebedrag() >= 50000 && subsidie.getSubsidiebedrag() < 200000) {
                cat2 = true;
            } else if (subsidie.getSubsidiebedrag() >= 200000 && subsidie.getSubsidiebedrag() < 1000000) {
                cat3 = true;
            } else if (subsidie.getSubsidiebedrag() > 1000000) {
                cat4 = true;
            }

            if (gegevenBudget < 50000){// als gegeven budget cat1
                if (cat2){
                    percentageGroep2 = percentageGroep2 - 10;
                }else if(!cat1){
                    percentageGroep2 = percentageGroep2 - 15;
                }
            } else if (gegevenBudget >= 50000 && gegevenBudget < 200000) { // als gegeven budget cat2
                if (cat1 || cat3){
                    percentageGroep2 = percentageGroep2 - 10;
                }else if(!cat2){
                    percentageGroep2 = percentageGroep2 - 15;
                }
            } else if (gegevenBudget >= 200000 && gegevenBudget < 1000000) {// als gegeven budget cat3
                if (cat2 || cat4){
                    percentageGroep2 = percentageGroep2 - 10;
                }else if(!cat3){
                    percentageGroep2 = percentageGroep2 - 15;
                }
            } else if (gegevenBudget > 1000000) { // als gegeven budget cat4
                if (cat3){
                    percentageGroep2 = percentageGroep2 - 10;
                }else if(!cat4){
                    percentageGroep2 = percentageGroep2 - 15;
                }
            }

            //cofinanciering
            if (!subsidie.getSubsidiepercentage().equals("n.v.t.")){
                if (!bijdrage){
                    percentageGroep2 = percentageGroep2 - 20;
                    System.out.println("-20");
                }
            }

            System.out.println("groep1: " + percentageGroep1);
            System.out.println("groep2: " + percentageGroep2);
            subsidie.setMatchingPercentage(percentageGroep1 + percentageGroep2);
            filteredSubsidies.add(subsidie);
        }

        return filteredSubsidies;
    }
}
