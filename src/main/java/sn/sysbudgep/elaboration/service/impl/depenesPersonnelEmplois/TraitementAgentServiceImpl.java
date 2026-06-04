package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.TraitementAgentRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.TraitementAgentService;

import java.util.List;

@Service
public class TraitementAgentServiceImpl implements TraitementAgentService {

    private final TraitementAgentRepository traitementAgentRepository;

    public TraitementAgentServiceImpl(TraitementAgentRepository traitementAgentRepository) {
        this.traitementAgentRepository = traitementAgentRepository;
    }

    @Override
    public List<TraitementAgentDto> traitementAgent(ParametreRechercheDTO pr) {
        return traitementAgentRepository.traitementAgent(pr.getExeCode(), pr.getMatricule());
    }

}