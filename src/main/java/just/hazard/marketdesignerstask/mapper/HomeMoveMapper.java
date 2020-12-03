package just.hazard.marketdesignerstask.mapper;

import just.hazard.marketdesignerstask.dto.HomeMove;
import just.hazard.marketdesignerstask.entity.HomeMoveApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface HomeMoveMapper {
    @Mapping(target = "departure_si", source = "departureAddress.si")
    @Mapping(target = "departure_gu", source = "departureAddress.gu")
    @Mapping(target = "departure_dong", source = "departureAddress.dong")
    @Mapping(target = "arrive_si", source = "arriveAddress.si")
    @Mapping(target = "arrive_gu", source = "arriveAddress.gu")
    @Mapping(target = "arrive_dong", source = "arriveAddress.dong")
    HomeMove homeMove(HomeMoveApplication homeMoveApplication);
}
