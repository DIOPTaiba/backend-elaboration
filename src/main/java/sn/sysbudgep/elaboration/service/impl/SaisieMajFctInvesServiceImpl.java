package sn.sysbudgep.elaboration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.repository.SaisieMajFctInvesRepository;
import sn.sysbudgep.elaboration.service.SaisieMajFctInvesService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaisieMajFctInvesServiceImpl implements SaisieMajFctInvesService {

    private final SaisieMajFctInvesRepository saisieMajFctInvesRepository;

    @Override
    public List<ProjetDeBudgetDto> getProjetDeBudget(int expbExe) {
        return saisieMajFctInvesRepository.getProjetDeBudget(expbExe);
    }
}
