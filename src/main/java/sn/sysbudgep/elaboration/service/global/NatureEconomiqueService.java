package sn.sysbudgep.elaboration.service.global;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface NatureEconomiqueService {
    // Lignes budget (Natures économiques) dont aucun agent du chapitre ne bénéficie
    List<LigneBudgetDto> naturesEconomiques(ParametreRechercheDTO pr) ;

}