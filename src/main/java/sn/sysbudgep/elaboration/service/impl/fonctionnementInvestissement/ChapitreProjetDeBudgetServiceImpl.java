package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ChapitreProjetDeBudgetDto;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.ChapitreProjetDeBudgetRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.ChapitreProjetDeBudgetService;

import java.util.List;

@Service
public class ChapitreProjetDeBudgetServiceImpl implements ChapitreProjetDeBudgetService {

    private final ChapitreProjetDeBudgetRepository chapitreProjetDeBudgetRepository;

    public ChapitreProjetDeBudgetServiceImpl(ChapitreProjetDeBudgetRepository chapitreProjetDeBudgetRepository) {
        this.chapitreProjetDeBudgetRepository = chapitreProjetDeBudgetRepository;
    }

    @Override
    public List<ChapitreProjetDeBudgetDto> getChapitresInvestissement(String secId, String sfinCode, String proId, String proCode) {
        return chapitreProjetDeBudgetRepository.findChapitresInvestissement(secId, sfinCode, proId, proCode);
    }

    @Override
    public List<ChapitreProjetDeBudgetDto> getChapitreFonctionnement(String secId, String sfinCode, String proId) {
        return chapitreProjetDeBudgetRepository.findChapitreFonctionnement(secId, sfinCode, proId);
    }
}