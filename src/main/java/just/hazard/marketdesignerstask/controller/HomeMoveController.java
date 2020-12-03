package just.hazard.marketdesignerstask.controller;

import just.hazard.marketdesignerstask.dto.HomeMoveDTO;
import just.hazard.marketdesignerstask.service.HomeMoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("homemove")
@RequiredArgsConstructor
public class HomeMoveController {

    private final HomeMoveService homeMoveService;

    @GetMapping
    public ResponseEntity<HomeMoveDTO> getHomeMove() {

        HomeMoveDTO result = homeMoveService.getHomeMoves();

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
