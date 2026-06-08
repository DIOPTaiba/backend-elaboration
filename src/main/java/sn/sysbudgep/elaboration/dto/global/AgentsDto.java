package sn.sysbudgep.elaboration.dto.global;

import java.math.BigDecimal;

public interface AgentsDto {
    Integer getIdTraitement();
    String getPrenom();
    String getNom();
    String getEmploi();
    String getMatricule();
    BigDecimal getMontant();
    BigDecimal getMontantTraitementsSalaires();
    BigDecimal getMontantPrimes();
    BigDecimal getMontantIndemnites();
    BigDecimal getMontantCotisationsSociales();
    BigDecimal getMontantPrestationsFamiliales();
    BigDecimal getMontantPrisesChargeMedicales();
    BigDecimal getMontantContractuels();
    BigDecimal getMontantAutresChargesPersonnel();
    BigDecimal getEffectif();
    BigDecimal getBudgetPrevu();
    String getCodeAction();
    String getLibAction();
    String getCodeActivite();
    String getLibActivite();
    String getChapitre();
    String getStatut();
    String getAge();
}
