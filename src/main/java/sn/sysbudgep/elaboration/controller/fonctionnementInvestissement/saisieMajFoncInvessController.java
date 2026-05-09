package sn.sysbudgep.elaboration.controller.fonctionnementInvestissement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProgrammeDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.TypeFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.SourceFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.CategorieDepenseDto;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

import java.util.List;

@RestController
@RequestMapping("/saisie-maj")
public class saisieMajFoncInvessController {

    @Autowired
    private SaisieMajFctInvesService saisieMajFctInvesService;

    @GetMapping("/projets-budget/{exe}")
    public ResponseEntity<ProjetDeBudgetDto> getProjetDeBudget(@PathVariable int exe) {
        return ResponseEntity.ok(saisieMajFctInvesService.getProjetDeBudget(exe));
    }

    @GetMapping("/programmes/{secId}/{exercice}")
    public ResponseEntity<List<ProgrammeDto>> getProgrammes(
            @PathVariable int secId,
            @PathVariable String exercice) {
        return ResponseEntity.ok(saisieMajFctInvesService.getProgrammes(secId, exercice));
    }

    @GetMapping("/types-fin")
    public ResponseEntity<List<TypeFinDto>> getAllTypeFin() {
        return ResponseEntity.ok(saisieMajFctInvesService.getAllTypeFin());
    }

    @GetMapping("/sources-fin/{tfinId}")
    public ResponseEntity<List<SourceFinDto>> getSourceFinByTypeFin(@PathVariable int tfinId) {
        return ResponseEntity.ok(saisieMajFctInvesService.getSourceFinByTypeFin(tfinId));
    }

    @GetMapping("/categories-depense/{proCode}")
    public ResponseEntity<List<CategorieDepenseDto>> getCategoriesDepense(@PathVariable String proCode) {
        return ResponseEntity.ok(saisieMajFctInvesService.getCategoriesDepense(proCode));
    }
}