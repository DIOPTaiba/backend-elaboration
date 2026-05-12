package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ChapitreProjetDeBudgetDto;

import java.util.List;

public interface ChapitreProjetDeBudgetService {
    List<ChapitreProjetDeBudgetDto> getChapitresInvestissement(String secId, String sfinCode, String proId, String proCode);
    List<ChapitreProjetDeBudgetDto> getChapitreFonctionnement(String secId, String sfinCode, String proId);
}