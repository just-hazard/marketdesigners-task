package just.hazard.marketdesignerstask.service;

import just.hazard.marketdesignerstask.dto.ClientDTO;
import just.hazard.marketdesignerstask.entity.Client;
import just.hazard.marketdesignerstask.mapper.ClientMapper;
import just.hazard.marketdesignerstask.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientDTO> getClients() {
        ClientMapper mapper = Mappers.getMapper(ClientMapper.class);

        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> result = new ArrayList<>();
        for(Client client : clients) {
            result.add(mapper.clientDTO(client));
        }
        return result;
    }
}
