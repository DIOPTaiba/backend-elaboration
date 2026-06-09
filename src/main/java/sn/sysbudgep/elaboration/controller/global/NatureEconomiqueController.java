package sn.sysbudgep.elaboration.controller.global;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.service.global.AgentsService;
import sn.sysbudgep.elaboration.service.global.NatureEconomiqueService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/natureEconomique")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class NatureEconomiqueController {

    private final NatureEconomiqueService natureEconomiqueService;

    public NatureEconomiqueController(NatureEconomiqueService natureEconomiqueService) {
        this.natureEconomiqueService = natureEconomiqueService;
    }

    // Lignes budget (Natures économiques) dont aucun agent du chapitre ne bénéficie
    @PostMapping(value = "byExeCodeChapId")
    public List<LigneBudgetDto> naturesEconomiques(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return natureEconomiqueService.naturesEconomiques(pr);
    }

}