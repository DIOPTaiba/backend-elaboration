package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;

import java.util.List;

public interface TraitementAgentService {

        // Données traitement individuel d'un agent
        List<TraitementAgentDto> traitementIndividuel(ParametreRechercheDTO pr);

        // Données traitement collectif
        List<TraitementAgentDto> traitementCollectif(ParametreRechercheDTO pr);

        // Liste agents par chapId, idLigne
        List<AgentsDto> agentsChapNatId(ParametreRechercheDTO pr);
}
