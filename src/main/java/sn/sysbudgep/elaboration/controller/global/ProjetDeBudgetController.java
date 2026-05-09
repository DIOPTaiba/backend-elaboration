package sn.sysbudgep.elaboration.controller.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.global.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.service.global.ProjetDeBudgetService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProjetDeBudgetController {

    private final ProjetDeBudgetService projetDeBudgetService;

    public ProjetDeBudgetController(ProjetDeBudgetService projetDeBudgetService) {
        this.projetDeBudgetService = projetDeBudgetService;
    }

    @GetMapping("/projetsBudget/{exe}")
    public ResponseEntity<ProjetDeBudgetDto> getProjetDeBudget(@PathVariable int exe) {
        return ResponseEntity.ok(projetDeBudgetService.getProjetDeBudget(exe));
    }
}