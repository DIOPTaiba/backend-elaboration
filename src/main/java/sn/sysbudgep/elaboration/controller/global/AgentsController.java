package sn.sysbudgep.elaboration.controller.global;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
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
    public List<AgentsDto> agents(@RequestBody ParametreRechercheDTO pr) {
        return agentsService.agents(pr);
    }

    // Ajputer agent
    /*@PostMapping(value = "/ajouterAgent")
    public ResponseDto ajouterAgent(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return agentsService.ajouterAgent(pr);
    }*/

    // Agents flottants
    @PostMapping(value = "/flottants")
    public List<AgentsDto> agentsFlottants() {
        return agentsService.agentsFlottants();
    }

    // Agents non affectés dans un chapitre
    @PostMapping(value = "/nonAffectesChap")
    public List<AgentsDto> agentsNonAffectesChap(@RequestBody ParametreRechercheDTO pr)  {
        return agentsService.agentsNonAffectesChap(pr);
    }

    // Agents à intégrer ( agents sans chapitre et agents flottants)
    @PostMapping(value = "/agentsAIntegrer")
    public List<AgentsDto> agentsAIntegrer(@RequestBody ParametreRechercheDTO pr) {
        return agentsService.agentsAIntegrer(pr);
    }

}