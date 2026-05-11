package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.ActiviteDto;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.ActiviteProjetDeBudgetRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.ActiviteProjetDeBudgetService;

import java.util.List;

@Service
public class ActiviteProjetDeBudgetServiceImpl implements ActiviteProjetDeBudgetService {

    private final ActiviteProjetDeBudgetRepository activiteProjetDeBudgetRepository;

    public ActiviteProjetDeBudgetServiceImpl(ActiviteProjetDeBudgetRepository activiteProjetDeBudgetRepository) {
        this.activiteProjetDeBudgetRepository = activiteProjetDeBudgetRepository;
    }

    @Override
    public List<ActiviteDto> getActivitesProjetDeBudget(String copCopId, String pappRef, String chapCode) {
        return activiteProjetDeBudgetRepository.findActivitesProjetDeBudget(copCopId, pappRef, chapCode);
    }
}