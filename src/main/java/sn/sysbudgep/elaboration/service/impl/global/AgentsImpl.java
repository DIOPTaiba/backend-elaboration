package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.Agents;
import sn.sysbudgep.elaboration.repository.global.AgentsRepository;
import sn.sysbudgep.elaboration.repository.global.CategorieDepenseRepository;
import sn.sysbudgep.elaboration.service.global.AgentsService;

import java.util.List;

@Service
public class AgentsImpl implements AgentsService {

    private final AgentsRepository agentsRepository;

    public AgentsImpl(AgentsRepository agentsRepository) {
        this.agentsRepository = agentsRepository;
    }

    @Override
    public List<Agents> agents(ParametreRechercheDTO pr) {
        return agentsRepository.agents(pr.getExeCode(), pr.getChapId(), pr.getMatricule(), pr.getCodeEmploi());
    }
}