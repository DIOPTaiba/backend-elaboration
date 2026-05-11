package sn.sysbudgep.elaboration.controller.fonctionnementInvestissement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ActionProjetDeBudgetDto;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.ActionProjetDeBudgetService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class ActionProjetDeBudgetController {

    private final ActionProjetDeBudgetService actionProjetDeBudgetService;

    public ActionProjetDeBudgetController(ActionProjetDeBudgetService actionProjetDeBudgetService) {
        this.actionProjetDeBudgetService = actionProjetDeBudgetService;
    }

    @GetMapping("/actionsProjetDeBudget/{proId}/{pappRef}/{chapCode}/{chapId}")
    public ResponseEntity<List<ActionProjetDeBudgetDto>> getActionsProjetDeBudget(
            @PathVariable String proId,
            @PathVariable String pappRef,
            @PathVariable String chapCode,
            @PathVariable String chapId) {
        return ResponseEntity.ok(actionProjetDeBudgetService.getActionsProjetDeBudget(proId, pappRef, chapCode, chapId));
    }
}