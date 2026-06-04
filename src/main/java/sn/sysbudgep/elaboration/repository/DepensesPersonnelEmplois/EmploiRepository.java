package sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MajEmploisEffectifsDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

public interface EmploiRepository  extends JpaRepository<SaisieMajFctInves, String> {
    @Query(value = "select EMPAG_ID idEmploi, EMPAG_CODE codeEmploi, EMPAG_LIB libelleEmploi\n" +
            "from VB3_EMPLOI_AGENT\n" +
            "order by EMPAG_CODE", nativeQuery = true)
    List<EmploiDto> findAllEmplois();

    @Query(value = "SELECT \n" +
            "    t.AFFAG_EMPAG_ID emploiId, e.EMPAG_CODE emploiCode,\n" +
            "    e.EMPAG_LIB emploiLib, t.statut,\n" +
            "    SUM(NVL(t.effectif_prec,0)) effectif0,\n" +
            "    SUM(NVL(t.nombreAgent,0)) nombreAgent,\n" +
            "    SUM(NVL(t.nombreContractuel,0)) nombreContractuel,\n" +
            "    SUM(NVL(t.montant,0)) montant\n" +
            "FROM (\n" +
            "    SELECT \n" +
            "        a.AFFAG_EMPAG_ID,\n" +
            "        CASE \n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END statut,\n" +
            "        0 effectif_prec,\n" +
            "        COUNT(*) nombreAgent,\n" +
            "        SUM(\n" +
            "            CASE\n" +
            "                WHEN a.AFFAG_AGT_CATEG <> 'FP'\n" +
            "                THEN 1\n" +
            "                ELSE 0\n" +
            "            END\n" +
            "        ) nombreContractuel,\n" +
            "        0 montant\n" +
            "    FROM vb3_affectation_agent a\n" +
            "    WHERE a.AFFAG_EXPB_CODE =:exeCode\n" +
            "    AND a.AFFAG_PRO_ID =:proId\n" +
            "    AND (:idEmploi IS NULL OR a.AFFAG_EMPAG_ID = :idEmploi)\n" +
            "    GROUP BY\n" +
            "        a.AFFAG_EMPAG_ID,\n" +
            "        CASE\n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END\n" +
            "    UNION ALL\n" +
            "    SELECT\n" +
            "        a.AFFAG_EMPAG_ID,\n" +
            "        CASE\n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END statut,\n" +
            "        COUNT(*) effectif_prec,\n" +
            "        0 nombreAgent, 0 nombreContractuel, 0 montant\n" +
            "    FROM vb3_hist_affectation_agent a\n" +
            "    WHERE a.AFFAG_EXPB_CODE =:exeCode0\n" +
            "    AND a.AFFAG_PRO_ID =:proId\n" +
            "    AND (:idEmploi IS NULL OR a.AFFAG_EMPAG_ID = :idEmploi)\n" +
            "    GROUP BY\n" +
            "        a.AFFAG_EMPAG_ID,\n" +
            "        CASE\n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END\n" +
            "    UNION ALL\n" +
            "    SELECT\n" +
            "        a.AFFAG_EMPAG_ID,\n" +
            "        CASE\n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END statut,\n" +
            "        0 effectif_prec, 0 nombreAgent,0 nombreContractuel,\n" +
            "        SUM(b.TRTAG_MONT) montant\n" +
            "    FROM vb3_affectation_agent a\n" +
            "         JOIN vb3_traitement_agent b\n" +
            "           ON a.AFFAG_AGT_MAT = b.TRTAG_AGT_MAT\n" +
            "    WHERE a.AFFAG_EXPB_CODE =:exeCode\n" +
            "    AND a.AFFAG_PRO_ID =:proId\n" +
            "    AND (:idEmploi IS NULL OR a.AFFAG_EMPAG_ID = :idEmploi)\n" +
            "    GROUP BY\n" +
            "        a.AFFAG_EMPAG_ID,\n" +
            "        CASE\n" +
            "            WHEN a.AFFAG_AGT_CATEG = 'FP'\n" +
            "            THEN 'Agent solde'\n" +
            "            ELSE 'Contractuel'\n" +
            "        END\n" +
            ") t\n" +
            "INNER JOIN VB3_EMPLOI_AGENT e\n" +
            "    ON t.AFFAG_EMPAG_ID = e.EMPAG_ID\n" +
            "GROUP BY\n" +
            "    t.AFFAG_EMPAG_ID,e.EMPAG_CODE, e.EMPAG_LIB, t.statut\n" +
            "ORDER BY e.EMPAG_CODE,t.statut", nativeQuery = true)
    List<MajEmploisEffectifsDto> emploisEffectifs(@Param("exeCode0") String exeCode0, @Param("exeCode") String exeCode,
                                                  @Param("proId") String proId, @Param("idEmploi") Integer idEmploi);

}
