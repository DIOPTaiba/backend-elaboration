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
            "    c.CHAP_CODE chapCode,\n" +
            "    c.CHAP_LIB chapLib, t.statut,\n" +
            "    SUM(NVL(t.effectif_prec,0)) effectif0,\n" +
            "    SUM(NVL(t.effectif,0)) effectif1,\n" +
            "    SUM(t.montant) montant\n" +
            "FROM (\n" +
            "    select a.AFFAG_CHAP_ID,\n" +
            "           decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel') statut,\n" +
            "           0 effectif_prec,\n" +
            "           count(*) effectif, 0 montant\n" +
            "    from vb3_affectation_agent a\n" +
            "    where a.AFFAG_AGT_CATEG NOT IN ('FP') \n" +
            "    and a.AFFAG_EXPB_CODE=:exeCode1\n" +
            "    and a.AFFAG_PRO_ID =:proId\n" +
            "    group by a.AFFAG_CHAP_ID,\n" +
            "             decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel')\n" +
            "    union\n" +
            "    select a.AFFAG_CHAP_ID,\n" +
            "           decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel') statut,\n" +
            "           count(*) effectif_prec,\n" +
            "           0 effectif, 0 montant\n" +
            "    from vb3_hist_affectation_agent a\n" +
            "    where a.AFFAG_AGT_CATEG NOT IN ('FP') \n" +
            "    and a.AFFAG_EXPB_CODE=:exeCode\n" +
            "    and a.AFFAG_PRO_ID =:proId\n" +
            "    group by a.AFFAG_CHAP_ID,\n" +
            "             decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel')\n" +
            "    union\n" +
            "    select a.AFFAG_CHAP_ID,\n" +
            "           decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel') statut,\n" +
            "           0 effectif_prec, 0 effectif,\n" +
            "           sum(b.TRTAG_MONT) montant\n" +
            "    from vb3_affectation_agent a,\n" +
            "         vb3_traitement_agent b \n" +
            "    where a.AFFAG_AGT_MAT=b.TRTAG_AGT_MAT\n" +
            "    and a.AFFAG_AGT_CATEG NOT IN ('FP') \n" +
            "    and a.AFFAG_EXPB_CODE=:exeCode1\n" +
            "    and a.AFFAG_PRO_ID =:proId\n" +
            "    group by a.AFFAG_CHAP_ID,\n" +
            "             decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel')\n" +
            "    union\n" +
            "    select a.AFFAG_CHAP_ID,\n" +
            "           decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel') statut,\n" +
            "           0 effectif_prec, 0 effectif,\n" +
            "           sum(b.TRTAG_MONT) montant\n" +
            "    from vb3_affectation_agent a,\n" +
            "         vb3_traitement_agent b \n" +
            "    where a.AFFAG_AGT_MAT=b.TRTAG_AGT_MAT\n" +
            "    and a.AFFAG_AGT_CATEG IN ('FP') \n" +
            "    and a.AFFAG_EXPB_CODE=:exeCode1\n" +
            "    and a.AFFAG_PRO_ID =:proId\n" +
            "    group by a.AFFAG_CHAP_ID,\n" +
            "             decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel')\n" +
            "    union\n" +
            "    select a.AFFAG_CHAP_ID,\n" +
            "           decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel') statut,\n" +
            "           0 effectif_prec,\n" +
            "           count(*) effectif, 0 montant\n" +
            "    from vb3_affectation_agent a\n" +
            "    where a.AFFAG_AGT_CATEG IN ('FP') \n" +
            "    and a.AFFAG_EXPB_CODE=:exeCode1\n" +
            "    and a.AFFAG_PRO_ID =:proId\n" +
            "    group by a.AFFAG_CHAP_ID,\n" +
            "             decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel')\n" +
            "    union\n" +
            "    select a.AFFAG_CHAP_ID,\n" +
            "           decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel') statut,\n" +
            "           count(*) effectif_prec,\n" +
            "           0 effectif, 0 montant\n" +
            "    from vb3_hist_affectation_agent a\n" +
            "    where a.AFFAG_AGT_CATEG IN ('FP') \n" +
            "    and a.AFFAG_EXPB_CODE=:exeCode\n" +
            "    and a.AFFAG_PRO_ID =:proId\n" +
            "    group by a.AFFAG_CHAP_ID,\n" +
            "    decode(a.AFFAG_AGT_CATEG,'FP','Agent solde','Contractuel')\n" +
            ") t\n" +
            "INNER JOIN VB3_CHAPITRE c\n" +
            "    ON t.AFFAG_CHAP_ID = c.CHAP_ID\n" +
            "GROUP BY \n" +
            "    t.AFFAG_CHAP_ID, c.CHAP_CODE,\n" +
            "    c.CHAP_LIB, t.statut\n" +
            "ORDER BY \n" +
            "    c.CHAP_CODE,\n" +
            "    t.statut", nativeQuery = true)
    List<ChapitreEffectifsDto> chapitreEffectifs(@Param("exeCode") String exeCode, @Param("exeCode1") String exeCode1, @Param("proId") String proId);

}