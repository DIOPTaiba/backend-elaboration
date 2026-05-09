package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.repository.global.ProjetDeBudgetRepository;
import sn.sysbudgep.elaboration.service.global.ProjetDeBudgetService;

@Service
public class ProjetDeBudgetServiceImpl implements ProjetDeBudgetService {

    private final ProjetDeBudgetRepository projetDeBudgetRepository;

    public ProjetDeBudgetServiceImpl(ProjetDeBudgetRepository projetDeBudgetRepository) {
        this.projetDeBudgetRepository = projetDeBudgetRepository;
    }

    @Override
    public ProjetDeBudgetDto getProjetDeBudget(int exe) {
        return projetDeBudgetRepository.findProjetDeBudget(exe);
    }
}