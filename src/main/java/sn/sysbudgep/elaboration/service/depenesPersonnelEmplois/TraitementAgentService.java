package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.classe.TraitementsAgentDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface TraitementAgentService {

        // Données traitement individuel d'un agent
        List<TraitementAgentDto> traitementIndividuel(ParametreRechercheDTO pr);

        // Données traitement collectif
        List<TraitementAgentDto> traitementCollectif(ParametreRechercheDTO pr);

        // Liste agents par chapId, idLigne à modifier
        List<AgentsDto> agentsChapNatId(ParametreRechercheDTO pr);

        // Modification traitement collectif
        ResponseDto majTraitementAgent(List<TraitementsAgentDto> traitementsAgentDtos) throws SQLException, ParseException;

        // Liste agents à insérer
        List<AgentsDto> agentsAAjouter(ParametreRechercheDTO pr);

        // Insertion traitement collectif
        ResponseDto insertTraitementAgent(List<TraitementsAgentDto> traitementsAgentDtos) throws SQLException, ParseException;

}
