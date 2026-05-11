package sn.sysbudgep.elaboration.repository.fonctionnementInvestissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ActiviteProjetDeBudgetDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface ActiviteProjetDeBudgetRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT DISTINCT cop_id AS copId, cop_code AS copCode, cop_libelle AS copLibelle, " +
            "cop_nip_code AS copNipCode, budc_code AS budcCode, budc_stat_cod AS budcStatCod " +
            "FROM vb3_comp_prog, vb3_budget_comp " +
            "WHERE cop_id = budc_cop_id " +
            "AND cop_cop_id = :copCopId " +
            "AND BUDC_PAPP_REF = :pappRef " +
            "AND cop_pptip_id = DECODE(SUBSTR(:chapCode, 1, 2), '39', 'O', 'N') " +
            "ORDER BY cop_code", nativeQuery = true)
    List<ActiviteProjetDeBudgetDto> findActivitesProjetDeBudget(
            @Param("copCopId") String copCopId,
            @Param("pappRef") String pappRef,
            @Param("chapCode") String chapCode
    );
}