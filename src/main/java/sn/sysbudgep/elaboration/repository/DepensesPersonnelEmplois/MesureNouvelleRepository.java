package sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MesureNouvelleDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

public interface MesureNouvelleRepository extends JpaRepository<SaisieMajFctInves, String> {
    @Query(value = "select e.EMPAG_CODE codeMesureNouvelle,e.EMPAG_LIB libelleMesureNouvelle, MNP_EFFECTIF effectif,m.MNP_OBS observation\n" +
            "from vb3_mes_nouv_pers m, vb3_emploi_agent e\n" +
            "where m.MNP_EMP_ID=e.EMPAG_ID\n" +
            "and m.MNP_CHAP_ID =:chapId\n" +
            "and m.MNP_EXPB_CODE=:exeCode\n" +
            "order by e.EMPAG_CODE", nativeQuery = true)
    List<MesureNouvelleDto> mesuresNouvelles (@Param("exeCode") String exeCode, @Param("chapId") String chapId);
}
