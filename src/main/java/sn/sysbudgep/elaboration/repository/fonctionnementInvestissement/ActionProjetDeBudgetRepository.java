package sn.sysbudgep.elaboration.repository.fonctionnementInvestissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ActionProjetDeBudgetDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface ActionProjetDeBudgetRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT DISTINCT b.cop_id AS copId, b.cop_code AS copCode, b.cop_libelle AS copLibelle " +
            "FROM vb3_comp_prog a, vb3_budget_comp, vb3_comp_prog b " +
            "WHERE a.cop_id = budc_cop_id " +
            "AND a.cop_pro_id = :proId " +
            "AND BUDC_PAPP_REF = :pappRef " +
            "AND a.cop_cop_id = b.cop_id " +
            "AND a.cop_pptip_id = DECODE(SUBSTR(:chapCode, 1, 2), '39', 'O', 'N') " +
            "AND b.cop_id IN ( " +
            "    SELECT COPC_COP_ID FROM vb3_comp_chapitre " +
            "    WHERE COPC_CHAP_ID = :chapId " +
            ") " +
            "ORDER BY b.cop_code", nativeQuery = true)
    List<ActionProjetDeBudgetDto> findActionsProjetDeBudget(
            @Param("proId") String proId,
            @Param("pappRef") String pappRef,
            @Param("chapCode") String chapCode,
            @Param("chapId") String chapId
    );
}