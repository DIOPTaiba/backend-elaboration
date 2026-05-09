package sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves;

import java.sql.Timestamp;

public interface ProjetDeBudgetDto {
    String getExpbCode();
    String getExpbLib();
    Timestamp getExpbDebut();
}