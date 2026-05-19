package sn.sysbudgep.elaboration.controller.global;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.Agents;
import sn.sysbudgep.elaboration.dto.global.Emplois;
import sn.sysbudgep.elaboration.service.global.AgentsService;
import sn.sysbudgep.elaboration.service.global.EmploisService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/emplois")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class EmploisController {

    private final EmploisService emploisService;

    public EmploisController(EmploisService emploisService) {
        this.emploisService = emploisService;
    }

    // Tous les agents par chapitre ou un seul agent si matricule est renseigné
    @GetMapping(value = "")
    public List<Emplois> emplois() {
        System.out.println("TTTTTTTTTT "+emploisService.emplois().size());
        return emploisService.emplois();
    }

}