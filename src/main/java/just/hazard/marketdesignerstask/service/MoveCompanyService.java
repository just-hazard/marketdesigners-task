package just.hazard.marketdesignerstask.service;

import just.hazard.marketdesignerstask.dto.MoveCompanyDTO;
import just.hazard.marketdesignerstask.entity.MoveCompany;
import just.hazard.marketdesignerstask.mapper.MoveCompanyMapper;
import just.hazard.marketdesignerstask.repositories.MoveCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoveCompanyService {

    private final MoveCompanyRepository moveCompanyRepository;

    public List<MoveCompanyDTO> getMoveCompany() {

        MoveCompanyMapper mapper = Mappers.getMapper(MoveCompanyMapper.class);

        List<MoveCompany> moveCompanies = moveCompanyRepository.findAll();
        List<MoveCompanyDTO> result = new ArrayList<>();
        for(MoveCompany moveCompany : moveCompanies) {
            result.add(mapper.moveCompanyDTO(moveCompany));
        }
        return result;
    }
}
