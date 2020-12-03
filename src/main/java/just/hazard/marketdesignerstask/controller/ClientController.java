package just.hazard.marketdesignerstask.controller;

import just.hazard.marketdesignerstask.dto.ClientDTO;
import just.hazard.marketdesignerstask.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClient() {

        List<ClientDTO> result = clientService.getClients();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
