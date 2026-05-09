package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;

import java.sql.SQLException;
import java.text.ParseException;

public interface SaisieMajFctInvesService {
    // Montants AE/CP d'une ligne d'enveloppe pour n1, n2 et n3
    MontantAECPDto repositionnerDelegationCredits(ParametreRechercheDTO pr) throws SQLException, ParseException;
}