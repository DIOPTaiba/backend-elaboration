package sn.sysbudgep.elaboration.controller.DepensesPersonnelEmplois;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.ChapitreEffectifsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MajEmploisEffectifsService;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/majEffectifEmplois")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class MajEffectifsEmploisController {

    private final MajEmploisEffectifsService majEmploisEffectifsService;

    public MajEffectifsEmploisController(MajEmploisEffectifsService majEmploisEffectifsService) {
        this.majEmploisEffectifsService = majEmploisEffectifsService;
    }

    // Montants AE/CP d'une ligne d'enveloppe pour n1, n2 et n3
    @PostMapping(value = "chapitreEffectifs")
    public List<ChapitreEffectifsDto> chapitreEffectifs(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return majEmploisEffectifsService.chapitreEffectifs(pr);
    }
}