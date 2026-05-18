package sn.sysbudgep.elaboration.dto.global;

import java.math.BigDecimal;
import java.util.Date;

public interface LigneBudgetDto {
    BigDecimal getAeLFI0();
    BigDecimal getCpLFI0();
    BigDecimal getAeLFI1();
    BigDecimal getCpLFI1();
    String getCodeAction();
    String getLibAction();
    String getCodeActivite();
    String getLibActivite();
    String getCodeLigne();
    String getLibLigne();
    String getIdLigne();
    String getLbuCode();
    Date getDateLigne();
}