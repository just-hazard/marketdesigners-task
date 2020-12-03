package just.hazard.marketdesignerstask.controller;

import just.hazard.marketdesignerstask.dto.MoveCompanyDTO;
import just.hazard.marketdesignerstask.service.MoveCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class MoveCompanyController {

    private final MoveCompanyService moveCompanyService;

    @GetMapping
    public ResponseEntity<List<MoveCompanyDTO>> getMoveCompany() {

        List<MoveCompanyDTO> result = moveCompanyService.getMoveCompany();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
