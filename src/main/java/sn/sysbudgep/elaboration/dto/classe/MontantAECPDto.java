package sn.sysbudgep.elaboration.dto.classe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MontantAECPDto {
        private BigDecimal montantN1CP;
        private BigDecimal montantN2CP;
        private BigDecimal montantN3CP;
        private BigDecimal montantN1AE;
        private BigDecimal montantN2AE;
        private BigDecimal montantN3AE;
}
