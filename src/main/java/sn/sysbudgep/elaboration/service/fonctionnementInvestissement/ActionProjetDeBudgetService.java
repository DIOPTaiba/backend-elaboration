package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ActionProjetDeBudgetDto;

import java.util.List;

public interface ActionProjetDeBudgetService {
    List<ActionProjetDeBudgetDto> getActionsProjetDeBudget(String proId, String pappRef, String chapCode, String chapId);
}