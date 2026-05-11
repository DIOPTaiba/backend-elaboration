package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.global.ActiviteDto;

import java.util.List;

public interface ActiviteProjetDeBudgetService {
    List<ActiviteDto> getActivitesProjetDeBudget(String copCopId, String pappRef, String chapCode);
}