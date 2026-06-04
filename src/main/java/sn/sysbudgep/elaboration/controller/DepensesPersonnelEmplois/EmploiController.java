package sn.sysbudgep.elaboration.controller.DepensesPersonnelEmplois;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MajEmploisEffectifsDto;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.EmploiService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/emplois")
@CrossOrigin(origins = "*",maxAge = 3600)
public class EmploiController {

    private final EmploiService emploiService;

    public EmploiController(EmploiService emploiService) {

        this.emploiService = emploiService;
    }
    @GetMapping("")
    public ResponseEntity<List<EmploiDto>> getAllEmplois() {
        return ResponseEntity.ok(emploiService.getAllEmplois());
    }

    // liste de chapitre dans maj emplois et effecitfs
    @PostMapping(value = "/emploisEffectifs")
    public List<MajEmploisEffectifsDto> emploisEffectifs(@RequestBody ParametreRechercheDTO pr) {
        return emploiService.emploisEffectifs(pr);
    }
}
