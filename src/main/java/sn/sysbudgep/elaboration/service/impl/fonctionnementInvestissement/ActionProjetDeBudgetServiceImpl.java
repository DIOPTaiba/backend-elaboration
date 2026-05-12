package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.ActionDto;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.ActionProjetDeBudgetRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.ActionProjetDeBudgetService;

import java.util.List;

@Service
public class ActionProjetDeBudgetServiceImpl implements ActionProjetDeBudgetService {

    private final ActionProjetDeBudgetRepository actionProjetDeBudgetRepository;

    public ActionProjetDeBudgetServiceImpl(ActionProjetDeBudgetRepository actionProjetDeBudgetRepository) {
        this.actionProjetDeBudgetRepository = actionProjetDeBudgetRepository;
    }

    @Override
    public List<ActionDto> getActionsProjetDeBudget(String proId, String pappRef, String chapCode, String chapId) {
        return actionProjetDeBudgetRepository.findActionsProjetDeBudget(proId, pappRef, chapCode, chapId);
    }
}