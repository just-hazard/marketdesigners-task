package just.hazard.marketdesignerstask.mapper;

import just.hazard.marketdesignerstask.dto.MoveCompanyDTO;
import just.hazard.marketdesignerstask.entity.MoveCompany;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MoveCompanyMapper {
    @Mapping(target = "si", source = "address.si")
    @Mapping(target = "gu", source = "address.gu")
    @Mapping(target = "dong", source = "address.dong")
    MoveCompanyDTO moveCompanyDTO(MoveCompany moveCompany);
}
