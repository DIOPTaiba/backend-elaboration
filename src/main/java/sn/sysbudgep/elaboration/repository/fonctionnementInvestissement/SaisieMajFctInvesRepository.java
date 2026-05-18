package sn.sysbudgep.elaboration.repository.fonctionnementInvestissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.ActiviteDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface SaisieMajFctInvesRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "select c.LBUC_DATE dateLigne,c.LBUC_CODE lbuCode, c.LBUC_LFI_AE aeLFI0, c.LBUC_LFI_CP cpLFI0, c.lbuc_ae_1 aeLFI1,c.lbuc_cp_1 cpLFI1, action.cop_code codeAction, action.cop_libelle libAction, \n" +
            "activite.cop_code codeActivite, activite.cop_libelle libActivite,\n" +
            "nat_code codeLigne, nat_libelle libLigne\n" +
            "from vb3_ligne_budget_comp_lfi c, tb_comp_prog action, tb_comp_prog activite, vb3_nature_eco\n" +
            "where c.lbuc_expb_code=:exeCode\n" +
            "and LBUC_ACTION_ID = action.cop_id \n" +
            "and LBUC_COP_ID = activite.cop_id\n" +
            "and lbuc_nat_id = nat_id\n" +
            "and c.lbuc_chap_id=:chapId\n" +
            "ORDER BY nat_code", nativeQuery = true)
    List<LigneBudgetDto> ligneBudget(@Param("exeCode") String exeCode, @Param("chapId") String chapId);

    @Query(value = "SELECT DISTINCT\n" +
            "    action.cop_code   AS codeAction,\n" +
            "    action.cop_libelle AS libAction,\n" +
            "    activite.cop_code  AS codeActivite,\n" +
            "    activite.cop_libelle AS libActivite\n" +
            "FROM SYSBUDGET.vb3_ligne_budget_comp_lfi c\n" +
            "         JOIN SYSBUDGET.tb_comp_prog action   ON LBUC_ACTION_ID = action.cop_id\n" +
            "         JOIN SYSBUDGET.tb_comp_prog activite ON LBUC_COP_ID = activite.cop_id\n" +
            "         JOIN SYSBUDGET.vb3_nature_eco        ON lbuc_nat_id = nat_id\n" +
            "WHERE c.lbuc_expb_code = :exeCode\n" +
            "  AND c.lbuc_chap_id = :chapId\n" +
            "GROUP BY action.cop_code, action.cop_libelle, activite.cop_code, activite.cop_libelle\n" +
            "ORDER BY activite.cop_code", nativeQuery = true)
    List<ActiviteDto> listeActiviteSaisie(@Param("exeCode") String exeCode, @Param("chapId") String chapId);

    @Query(value = "Select NAT_ID idLigne, NAT_CODE codeLigne, NAT_LIBELLE libLigne from vb3_nat_eco_budget where nat_cade_code=:cade_code\n" +
            "and nat_id not in (select LBUC_NAT_ID from vb3_ligne_budget_comp\n" +
            "                      where lbuc_budc_code=:budc_code\n" +
            "                      and lbuc_chap_id = :chap_id\n" +
            "                      and lbuc_cade_code = :cade_code\n" +
            "                      and lbuc_sfin_code = :sfin_code\n" +
            "and nat_code not like '211%'\n" +
            "and nat_code not in ('2131','2151')\n" +
            ")", nativeQuery = true)
    List<LigneBudgetDto> ligneSaisie(@Param("cade_code") String cadeCode,
                                     @Param("budc_code") String budcCode,
                                     @Param("chap_id") String chapId,
                                     @Param("sfin_code") String sfinCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM vb3_ligne_budget_comp_lfi WHERE LBUC_CODE = :lbucCode", nativeQuery = true)
    void supprimerLigneBudget(@Param("lbucCode") String lbucCode);

}