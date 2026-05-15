package sn.sysbudgep.elaboration.service.fonctionnementInvestissement;

import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.ActiviteDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface SaisieMajFctInvesService {
    // Montants AE/CP d'une ligne d'enveloppe pour n1, n2 et n3
    MontantAECPDto montantsAECPLigne(ParametreRechercheDTO pr) throws SQLException, ParseException;

    // Montants AE/CP d'une ligne d'enveloppe pour n1, n2 et n3
    MontantAECPDto montantsAECPProgramme(ParametreRechercheDTO pr) throws SQLException, ParseException;

    // Ligne budget
    List<LigneBudgetDto> lignesBudget(ParametreRechercheDTO pr) throws SQLException, ParseException;

    // Liste des activités pour la saisie
    List<ActiviteDto> listeActiviteSaisie(ParametreRechercheDTO pr);

    // Lignes disponibles pour la saisie
    List<LigneBudgetDto> ligneSaisie(ParametreRechercheDTO pr);
}