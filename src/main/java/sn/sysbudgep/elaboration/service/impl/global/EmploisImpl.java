package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.Agents;
import sn.sysbudgep.elaboration.dto.global.Emplois;
import sn.sysbudgep.elaboration.repository.global.AgentsRepository;
import sn.sysbudgep.elaboration.repository.global.EmploisRepository;
import sn.sysbudgep.elaboration.service.global.AgentsService;
import sn.sysbudgep.elaboration.service.global.EmploisService;

import java.util.List;

@Service
public class EmploisImpl implements EmploisService {

    private final EmploisRepository emploisRepository;

    public EmploisImpl(EmploisRepository emploisRepository) {
        this.emploisRepository = emploisRepository;
    }

    @Override
    public List<Emplois> emplois() {
        return emploisRepository.emplois();
    }
}