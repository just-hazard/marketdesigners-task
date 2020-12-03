package just.hazard.marketdesignerstask.service;

import just.hazard.marketdesignerstask.dto.HomeMoveDTO;
import just.hazard.marketdesignerstask.entity.HomeMoveApplication;
import just.hazard.marketdesignerstask.mapper.HomeMoveMapper;
import just.hazard.marketdesignerstask.repositories.HomeMoveRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeMoveService {

    private final HomeMoveRepository homeMoveRepository;

    public HomeMoveDTO getHomeMoves() {

        HomeMoveMapper mapper = Mappers.getMapper(HomeMoveMapper.class);

        List<HomeMoveApplication> homeMoveApplications = homeMoveRepository.findAll();
        HomeMoveDTO result = new HomeMoveDTO();
        result.setTotal_data_count(homeMoveRepository.count());
        for(HomeMoveApplication homeMove : homeMoveApplications) {
            result.getHomeMoveList().add(mapper.homeMove(homeMove));
        }
        return result;

    }
}
