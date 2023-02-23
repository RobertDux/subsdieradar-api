package com.example.subsidieradar.application;

import com.example.subsidieradar.data.SubsidieRepository;
import com.example.subsidieradar.domain.Match;
import com.example.subsidieradar.domain.Subsidie;
import com.example.subsidieradar.presentation.dto.InputDTO;
import com.example.subsidieradar.presentation.dto.MatchDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class MatchService {
    private final SubsidieRepository subsidieRadarRepository;

    public MatchService(SubsidieRepository subsidieRadarRepository) {
        this.subsidieRadarRepository = subsidieRadarRepository;
    }

    public MatchDTO matchSubsidies(InputDTO input) throws Exception{
        try {
            System.out.println("match service called");
            Match match = new Match();
            List<Subsidie> subsidies = subsidieRadarRepository.findAll();

            MatchDTO outputDto = new MatchDTO(match.findMatches(subsidies, input.getSector(), input.getThema(), input.getTypeActiviteit(), input.getBudget(), input.getTypeAanvrager(), input.getProjectlocatie(), input.isBijdrage(), input.getSamenwerking()));
            System.out.println("matchsubsides:" + outputDto.getSubsidieList());
            return outputDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
