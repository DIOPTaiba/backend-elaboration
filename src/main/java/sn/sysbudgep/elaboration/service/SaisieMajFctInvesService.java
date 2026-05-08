package sn.sysbudgep.elaboration.service;

import sn.sysbudgep.elaboration.dto.ProjetDeBudgetDto;

import java.util.List;

public interface SaisieMajFctInvesService {
    List<ProjetDeBudgetDto> getProjetDeBudget(int expbExe);
}
