package sn.sysbudgep.elaboration.repository.fonctionnementInvestissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.dto.global.ProgrammeDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface SaisieMajFctInvesRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "select c.LBUC_LFI_AE aeLFI0, c.LBUC_LFI_CP cpLFI0, c.lbuc_ae_1 aeLFI1,c.lbuc_cp_1 cpLFI1, action.cop_code codeAction, action.cop_libelle libAction, \n" +
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

}