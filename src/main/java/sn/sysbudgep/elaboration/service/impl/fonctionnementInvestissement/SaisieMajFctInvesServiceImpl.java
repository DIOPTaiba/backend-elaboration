package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProgrammeDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.TypeFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.SourceFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.CategorieDepenseDto;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.SaisieMajFctInvesRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

import java.util.List;

@Service
public class SaisieMajFctInvesServiceImpl implements SaisieMajFctInvesService {

    @Autowired
    private SaisieMajFctInvesRepository saisieMajFctInvesRepository;

    @Override
    public ProjetDeBudgetDto getProjetDeBudget(int exe) {
        return saisieMajFctInvesRepository.findProjetDeBudget(exe);
    }

    @Override
    public List<ProgrammeDto> getProgrammes(int secId, String exercice) {
        return saisieMajFctInvesRepository.findProgrammes(secId, exercice);
    }

    @Override
    public List<TypeFinDto> getAllTypeFin() {
        return saisieMajFctInvesRepository.findAllTypeFin();
    }

    @Override
    public List<SourceFinDto> getSourceFinByTypeFin(int tfinId) {
        return saisieMajFctInvesRepository.findSourceFinByTypeFin(tfinId);
    }

    @Override
    public List<CategorieDepenseDto> getCategoriesDepense(String proCode) {
        return saisieMajFctInvesRepository.findCategoriesDepense(proCode);
    }
}