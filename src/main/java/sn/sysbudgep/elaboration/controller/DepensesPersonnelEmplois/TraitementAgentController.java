package sn.sysbudgep.elaboration.controller.DepensesPersonnelEmplois;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MesureNouvelleDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MesureNouvelleService;
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
    public List<TraitementAgentDto> traitementAgent(@RequestBody ParametreRechercheDTO pr){
        return traitementAgentService.traitementAgent(pr);
    }
}