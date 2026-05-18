package sn.sysbudgep.elaboration.controller.global;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.Agents;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;
import sn.sysbudgep.elaboration.service.global.AgentsService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/agents")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class AgentsController {

    private final AgentsService agentsService;

    public AgentsController(AgentsService agentsService) {
        this.agentsService = agentsService;
    }

    // Tous les agents par chapitre ou un seul agent si matricule est renseigné
    @PostMapping(value = "")
    public List<Agents> montantsAECPLigne(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return agentsService.agents(pr);
    }

}