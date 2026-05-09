package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.SaisieMajFctInvesRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

@Service
public class SaisieMajFctInvesServiceImpl implements SaisieMajFctInvesService {

    private final SaisieMajFctInvesRepository saisieMajFctInvesRepository;

    public SaisieMajFctInvesServiceImpl(SaisieMajFctInvesRepository saisieMajFctInvesRepository) {
        this.saisieMajFctInvesRepository = saisieMajFctInvesRepository;
    }
}