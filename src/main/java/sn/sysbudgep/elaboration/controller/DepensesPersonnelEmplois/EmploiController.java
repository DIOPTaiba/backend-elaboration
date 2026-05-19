package sn.sysbudgep.elaboration.controller.DepensesPersonnelEmplois;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.repository.global.TypeFinRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.EmploiService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class EmploiController {

    private final EmploiService emploiService;

    public EmploiController(EmploiService emploiService) {

        this.emploiService = emploiService;
    }
    @GetMapping("/emplois")
    public ResponseEntity<List<EmploiDto>> getAllEmplois() {
        return ResponseEntity.ok(emploiService.getAllEmplois());
    }
}
