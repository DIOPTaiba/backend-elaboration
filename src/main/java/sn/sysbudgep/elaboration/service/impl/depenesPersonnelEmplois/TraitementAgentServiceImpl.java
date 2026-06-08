package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.TraitementAgentRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.TraitementAgentService;

import java.util.List;

@Service
public class TraitementAgentServiceImpl implements TraitementAgentService {

    private final TraitementAgentRepository traitementAgentRepository;

    public TraitementAgentServiceImpl(TraitementAgentRepository traitementAgentRepository) {
        this.traitementAgentRepository = traitementAgentRepository;
    }

    // Données traitement individuel d'un agent
    @Override
    public List<TraitementAgentDto> traitementIndividuel(ParametreRechercheDTO pr) {
        return traitementAgentRepository.traitementIndividuel(pr.getExeCode(), pr.getMatricule());
    }

    // Données traitement collectif
    @Override
    public List<TraitementAgentDto> traitementCollectif(ParametreRechercheDTO pr) {
        return traitementAgentRepository.traitementCollectif(pr.getExeCode(), pr.getChapId());
    }

    // Liste agents par chapId, natId
    @Override
    public List<AgentsDto> agentsChapNatId(ParametreRechercheDTO pr) {
        return traitementAgentRepository.agentsChapNatId(pr.getExeCode(), pr.getChapId(), pr.getNatId());
    }

}