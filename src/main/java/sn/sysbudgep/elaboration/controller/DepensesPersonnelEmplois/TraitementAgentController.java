package sn.sysbudgep.elaboration.controller.DepensesPersonnelEmplois;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.classe.TraitementsAgentDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.TraitementAgentService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/traitementAgent")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class TraitementAgentController {

    private final TraitementAgentService traitementAgentService;

    public TraitementAgentController(TraitementAgentService traitementAgentService) {
        this.traitementAgentService = traitementAgentService;
    }

    // Traitement agent individuel
    @PostMapping(value = "/individuel")
    public List<TraitementAgentDto> traitementIndividuel(@RequestBody ParametreRechercheDTO pr){
        return traitementAgentService.traitementIndividuel(pr);
    }

    // Traitement agent individuel
    @PostMapping(value = "/collectif")
    public List<TraitementAgentDto> traitementCollectif(@RequestBody ParametreRechercheDTO pr){
        return traitementAgentService.traitementCollectif(pr);
    }

    // Liste agents par chapId, natId
    @PostMapping(value = "/agentsChapNatId")
    public List<AgentsDto> agentsChapNatId(@RequestBody ParametreRechercheDTO pr){
        return traitementAgentService.agentsChapNatId(pr);
    }

    // Modification traitement collectif
    @PostMapping(value = "/majTraitementAgent")
    public ResponseDto majTraitementAgent(@RequestBody List<TraitementsAgentDto> tr) throws SQLException, ParseException {
        return traitementAgentService.majTraitementAgent(tr);
    }
}