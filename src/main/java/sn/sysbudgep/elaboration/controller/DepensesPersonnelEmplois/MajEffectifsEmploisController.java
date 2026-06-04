package sn.sysbudgep.elaboration.controller.DepensesPersonnelEmplois;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MajEmploisEffectifsDto;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MajEmploisEffectifsService;

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

    // liste de chapitre dans maj emplois et effecitfs
    @PostMapping(value = "chapitreEffectifs")
    public List<MajEmploisEffectifsDto> chapitreEffectifs(@RequestBody ParametreRechercheDTO pr) throws SQLException, ParseException {
        return majEmploisEffectifsService.chapitreEffectifs(pr);
    }

}