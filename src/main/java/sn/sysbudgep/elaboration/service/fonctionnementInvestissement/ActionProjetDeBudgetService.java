package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;


import sn.sysbudgep.elaboration.dto.global.ActionDto;

import java.util.List;

public interface ActionProjetDeBudgetService {
    List<ActionDto> getActionsProjetDeBudget(String proId, String pappRef, String chapCode, String chapId);
}