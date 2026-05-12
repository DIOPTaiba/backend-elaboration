package sn.sysbudgep.elaboration.controller.fonctionnementInvestissement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ChapitreProjetDeBudgetDto;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.ChapitreProjetDeBudgetService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class ChapitreProjetDeBudgetController {

    private final ChapitreProjetDeBudgetService chapitreProjetDeBudgetService;

    public ChapitreProjetDeBudgetController(ChapitreProjetDeBudgetService chapitreProjetDeBudgetService) {
        this.chapitreProjetDeBudgetService = chapitreProjetDeBudgetService;
    }

    @GetMapping("/chapitresInvestissement/{secId}/{sfinCode}/{proId}/{proCode}")
    public ResponseEntity<List<ChapitreProjetDeBudgetDto>> getChapitresInvestissement(
            @PathVariable String secId,
            @PathVariable String sfinCode,
            @PathVariable String proId,
            @PathVariable String proCode) {
        return ResponseEntity.ok(chapitreProjetDeBudgetService.getChapitresInvestissement(secId, sfinCode, proId, proCode));
    }

    @GetMapping("/chapitresFonctionnement/{secId}/{sfinCode}/{proId}")
    public ResponseEntity<List<ChapitreProjetDeBudgetDto>> getChapitreFonctionnement(
            @PathVariable String secId,
            @PathVariable String sfinCode,
            @PathVariable String proId) {
        return ResponseEntity.ok(chapitreProjetDeBudgetService.getChapitreFonctionnement(secId, sfinCode, proId));
    }
}