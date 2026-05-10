package sn.sysbudgep.elaboration.controller.fonctionnementInvestissement;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/saisieMaj")
public class saisieMajFoncInvessController {

    private final SaisieMajFctInvesService saisieMajFctInvesService;

    public saisieMajFoncInvessController(SaisieMajFctInvesService saisieMajFctInvesService) {
        this.saisieMajFctInvesService = saisieMajFctInvesService;
    }

    // Montants AE/CP d'une ligne d'enveloppe pour n1, n2 et n3
    @PostMapping(value = "montantsAECPLigne")
    public MontantAECPDto montantsAECPLigne(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return saisieMajFctInvesService.montantsAECPLigne(pr);
    }

    // Montants AE/CP d'une programme d'enveloppe pour n1, n2 et n3
    @PostMapping(value = "montantsAECPPROGRAMME")
    public MontantAECPDto montantsAECPPROGRAMME(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return saisieMajFctInvesService.montantsAECPPROGRAMME(pr);
    }

    // Ligne budget
    @PostMapping(value = "ligneBudget")
    public List<LigneBudgetDto> ligneBudget(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return saisieMajFctInvesService.ligneBudget(pr);
    }
}