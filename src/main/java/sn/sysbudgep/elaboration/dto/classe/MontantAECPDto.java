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

        public BigDecimal getMontantN1CP() {
                return montantN1CP;
        }

        public void setMontantN1CP(BigDecimal montantN1CP) {
                this.montantN1CP = montantN1CP;
        }

        public BigDecimal getMontantN2CP() {
                return montantN2CP;
        }

        public void setMontantN2CP(BigDecimal montantN2CP) {
                this.montantN2CP = montantN2CP;
        }

        public BigDecimal getMontantN3CP() {
                return montantN3CP;
        }

        public void setMontantN3CP(BigDecimal montantN3CP) {
                this.montantN3CP = montantN3CP;
        }

        public BigDecimal getMontantN1AE() {
                return montantN1AE;
        }

        public void setMontantN1AE(BigDecimal montantN1AE) {
                this.montantN1AE = montantN1AE;
        }

        public BigDecimal getMontantN2AE() {
                return montantN2AE;
        }

        public void setMontantN2AE(BigDecimal montantN2AE) {
                this.montantN2AE = montantN2AE;
        }

        public BigDecimal getMontantN3AE() {
                return montantN3AE;
        }

        public void setMontantN3AE(BigDecimal montantN3AE) {
                this.montantN3AE = montantN3AE;
        }
}
