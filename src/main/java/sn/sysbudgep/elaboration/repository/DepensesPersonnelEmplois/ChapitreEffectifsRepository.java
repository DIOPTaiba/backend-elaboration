package sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.ChapitreEffectifsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface ChapitreEffectifsRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT \n" +
            "    t.AFFAG_CHAP_ID chapId,\n" +
            "    c.CHAP_CODE chapCode, c.CHAP_LIB chapLib, t.statut,\n" +
            "    SUM(NVL(t.effectif_prec,0)) effectif0,\n" +
            "    SUM(NVL(t.nombreAgent,0)) nombreAgent,\n" +
            "    SUM(NVL(t.nombreContractuel,0)) nombreContractuel,\n" +
            "    SUM(NVL(t.montant,0)) montant\n" +
            "FROM (\n" +
            "    /* Effectif année courante */\n" +
            "    SELECT \n" +
            "        a.AFFAG_CHAP_ID,\n" +
            "        CASE \n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END statut,\n" +
            "        0 effectif_prec,\n" +
            "        COUNT(*) nombreAgent,\n" +
            "        SUM(CASE \n" +
            "                WHEN a.AFFAG_AGT_CATEG <> 'FP'\n" +
            "                THEN 1\n" +
            "                ELSE 0\n" +
            "            END) nombreContractuel, 0 montant\n" +
            "    FROM vb3_affectation_agent a\n" +
            "    WHERE a.AFFAG_EXPB_CODE=:exeCode1\n" +
            "    AND a.AFFAG_PRO_ID =:proId\n" +
            "    GROUP BY \n" +
            "        a.AFFAG_CHAP_ID,\n" +
            "        CASE \n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END\n" +
            "    UNION ALL\n" +
            "    /* Effectif année précédente */\n" +
            "    SELECT \n" +
            "        a.AFFAG_CHAP_ID,\n" +
            "        CASE \n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END statut,\n" +
            "        COUNT(*) effectif_prec, 0 nombreAgent,\n" +
            "        0 nombreContractuel, 0 montant\n" +
            "    FROM vb3_hist_affectation_agent a\n" +
            "    WHERE a.AFFAG_EXPB_CODE=:exeCode\n" +
            "    AND a.AFFAG_PRO_ID =:proId\n" +
            "    GROUP BY \n" +
            "        a.AFFAG_CHAP_ID,\n" +
            "        CASE \n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END\n" +
            "    UNION ALL\n" +
            "    /* Montants */\n" +
            "    SELECT \n" +
            "        a.AFFAG_CHAP_ID,\n" +
            "        CASE \n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END statut, 0 effectif_prec,\n" +
            "        0 nombreAgent, 0 nombreContractuel,\n" +
            "        SUM(b.TRTAG_MONT) montant\n" +
            "    FROM vb3_affectation_agent a\n" +
            "    JOIN vb3_traitement_agent b\n" +
            "        ON a.AFFAG_AGT_MAT = b.TRTAG_AGT_MAT\n" +
            "    WHERE a.AFFAG_EXPB_CODE=:exeCode1\n" +
            "    AND a.AFFAG_PRO_ID =:proId\n" +
            "    GROUP BY \n" +
            "        a.AFFAG_CHAP_ID,\n" +
            "        CASE \n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END\n" +
            ") t\n" +
            "INNER JOIN VB3_CHAPITRE c\n" +
            "    ON t.AFFAG_CHAP_ID = c.CHAP_ID\n" +
            "GROUP BY \n" +
            "    t.AFFAG_CHAP_ID, c.CHAP_CODE,\n" +
            "    c.CHAP_LIB,  t.statut\n" +
            "ORDER BY \n" +
            "    c.CHAP_CODE, t.statut", nativeQuery = true)
    List<ChapitreEffectifsDto> chapitreEffectifs(@Param("exeCode") String exeCode, @Param("exeCode1") String exeCode1, @Param("proId") String proId);

}