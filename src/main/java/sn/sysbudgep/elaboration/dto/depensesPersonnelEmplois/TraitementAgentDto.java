package sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois;

import java.math.BigDecimal;

public interface TraitementAgentDto {
    String getParagraphe();
    String getLigneDepense();
    String getObservation();
    String getTexteReference();
    BigDecimal getMontant();
}
