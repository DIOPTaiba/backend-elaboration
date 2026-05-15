package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.ChapitreEffectifsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Service
public interface MajEmploisEffectifsService {
    // Chapitre et effectifs
    List<ChapitreEffectifsDto> chapitreEffectifs(ParametreRechercheDTO pr) throws SQLException, ParseException;

}