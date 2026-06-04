package sn.sysbudgep.elaboration.controller.DepensesPersonnelEmplois;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MesureNouvelleDto;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MesureNouvelleService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/mesureNouvelle")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class MesureNouvelleController {

    private final MesureNouvelleService mesureNouvelleService;

    public MesureNouvelleController(MesureNouvelleService mesureNouvelleService) {
        this.mesureNouvelleService = mesureNouvelleService;
    }

    // Montants AE/CP d'une ligne d'enveloppe pour n1, n2 et n3
    @PostMapping(value = "parChapId")
    public List<MesureNouvelleDto> mesureNouvelleChapId(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return mesureNouvelleService.mesuresNouvelles(pr);
    }

    // Insert Mesures Nouvelles
    @PostMapping(value = "")
    public ResponseDto insertMesuresNouvelles(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return mesureNouvelleService.insertMesuresNouvelles(pr);
    }
}