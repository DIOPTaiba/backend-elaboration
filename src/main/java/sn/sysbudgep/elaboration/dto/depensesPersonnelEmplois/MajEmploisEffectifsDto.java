package sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois;

import java.math.BigDecimal;

public interface MajEmploisEffectifsDto {
    String getChapId();
    String getChapCode();
    String getChapLib();
    String getEmploiId();
    String getEmploiCode();
    String getEmploiLib();
    String getStatut();
    int getEffectif0();
    int getNombreAgent();
    int getNombreContractuel();
    BigDecimal getMontant();
}