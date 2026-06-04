package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MesureNouvelleDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface TraitementAgentService {

        List<TraitementAgentDto> traitementAgent(ParametreRechercheDTO pr);
}
