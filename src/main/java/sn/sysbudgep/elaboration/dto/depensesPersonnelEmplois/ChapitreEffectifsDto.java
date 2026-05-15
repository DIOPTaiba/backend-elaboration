package sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois;

import java.math.BigDecimal;

public interface ChapitreEffectifsDto {
    String getChapId();
    String getChapCode();
    String getChapLib();
    String getStatut();
    int getEffectif0();
    int getEffectif1();
    BigDecimal getMontant();
}