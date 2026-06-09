package sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois;

import java.math.BigDecimal;

public interface TraitementAgentDto {
    String getParagraphe();
    String getCodeLigne();
    String getLibLigne();
    String getIdLigne();
    String getObservation();
    String getTexteReference();
    BigDecimal getMontant();
    BigDecimal getCreditsInscrits();
    BigDecimal getMesuresNouvelles();
    BigDecimal getMontantLFIExeCode0();
    BigDecimal getCreditsReevalues();
}
