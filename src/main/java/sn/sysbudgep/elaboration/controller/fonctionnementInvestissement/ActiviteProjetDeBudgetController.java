package sn.sysbudgep.elaboration.controller.fonctionnementInvestissement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.global.ActiviteDto;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.ActiviteProjetDeBudgetService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class ActiviteProjetDeBudgetController {

    private final ActiviteProjetDeBudgetService activiteProjetDeBudgetService;

    public ActiviteProjetDeBudgetController(ActiviteProjetDeBudgetService activiteProjetDeBudgetService) {
        this.activiteProjetDeBudgetService = activiteProjetDeBudgetService;
    }

    @GetMapping("/activitesProjetDeBudget/{copCopId}/{pappRef}/{chapCode}")
    public ResponseEntity<List<ActiviteDto>> getActivitesProjetDeBudget(
            @PathVariable String copCopId,
            @PathVariable String pappRef,
            @PathVariable String chapCode) {
        return ResponseEntity.ok(activiteProjetDeBudgetService.getActivitesProjetDeBudget(copCopId, pappRef, chapCode));
    }
}