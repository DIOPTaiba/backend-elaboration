package sn.sysbudgep.elaboration.dto.classe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneBudgetDto {
    private BigDecimal cpLFI0;
    private BigDecimal aeLFI1;
    private BigDecimal cpLFI1;
    private BigDecimal aeLFI0;
    private String codeAction;
    private String libAction;
    private String codeActivite;
    private String libActivite;
    private String codeLigne;
    private String libLigne;
}