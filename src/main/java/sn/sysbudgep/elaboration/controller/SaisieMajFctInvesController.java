package sn.sysbudgep.elaboration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.service.SaisieMajFctInvesService;

import java.util.List;

@RestController
@RequestMapping("/api/saisie-maj-fct-inves")
@RequiredArgsConstructor
@CrossOrigin
public class SaisieMajFctInvesController {

    private final SaisieMajFctInvesService saisieMajFctInvesService;

    @GetMapping("/projets-de-budget")
    public ResponseEntity<List<ProjetDeBudgetDto>> getProjetDeBudget(@RequestParam int expbExe) {
        return ResponseEntity.ok(saisieMajFctInvesService.getProjetDeBudget(expbExe));
    }
}
