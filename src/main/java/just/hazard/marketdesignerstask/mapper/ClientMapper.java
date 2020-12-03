package just.hazard.marketdesignerstask.mapper;

import just.hazard.marketdesignerstask.dto.ClientDTO;
import just.hazard.marketdesignerstask.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {

    ClientDTO clientDTO(Client client);
}
