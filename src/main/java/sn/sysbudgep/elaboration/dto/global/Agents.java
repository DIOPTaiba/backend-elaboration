package sn.sysbudgep.elaboration.dto.global;

import java.math.BigDecimal;

public interface Agents {
    String getNom();
    String getEmploi();
    String getMatricule();
    BigDecimal getMontantTraitementsSalaires();
    BigDecimal getMontantPrimes();
    BigDecimal getMontantIndemnites();
    BigDecimal getMontantCotisationsSociales();
    BigDecimal getMontantPrestationsFamiliales();
    BigDecimal getMontantPrisesChargeMedicales();
    BigDecimal getMontantContractuels();
    BigDecimal getMontantAutresChargesPersonnel();
    String getAction();
    String getActivite();
    String getChapitre();
    String getStatut();
    String getAge();
}
