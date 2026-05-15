package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.global.ChapitreDto;

import java.util.List;

public interface ChapitreProjetDeBudgetService {
    List<ChapitreDto> getChapitresInvestissement(String secId, String sfinCode, String proId, String proCode,String exeCode);
    List<ChapitreDto> getChapitreFonctionnement(String secId, String sfinCode, String proId, String exeCode);
}