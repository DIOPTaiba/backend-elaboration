package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProgrammeDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.TypeFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.SourceFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.CategorieDepenseDto;

import java.util.List;

public interface SaisieMajFctInvesService {
    ProjetDeBudgetDto getProjetDeBudget(int exe);
    List<ProgrammeDto> getProgrammes(int secId, String exercice);
    List<TypeFinDto> getAllTypeFin();
    List<SourceFinDto> getSourceFinByTypeFin(int tfinId);
    List<CategorieDepenseDto> getCategoriesDepense(String proCode);
}