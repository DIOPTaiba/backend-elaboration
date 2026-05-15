package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.ChapitreDto;
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
    public List<ChapitreDto> getChapitresInvestissement(String secId, String sfinCode, String proId, String proCode,String exeCode) {
        return chapitreProjetDeBudgetRepository.findChapitresInvestissement(secId, sfinCode, proId, proCode,exeCode);
    }

    @Override
    public List<ChapitreDto> getChapitreFonctionnement(String secId, String sfinCode, String proId,String exeCode) {
        return chapitreProjetDeBudgetRepository.findChapitreFonctionnement(secId, sfinCode, proId,exeCode);
    }
}