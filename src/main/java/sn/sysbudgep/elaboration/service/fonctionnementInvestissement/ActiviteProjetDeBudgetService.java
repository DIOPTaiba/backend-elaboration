package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ActiviteProjetDeBudgetDto;

import java.util.List;

public interface ActiviteProjetDeBudgetService {
    List<ActiviteProjetDeBudgetDto> getActivitesProjetDeBudget(String copCopId, String pappRef, String chapCode);
}