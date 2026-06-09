package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface NatureEconomiqueRepository extends JpaRepository<SaisieMajFctInves, String> {

    // Lignes budget (Natures économiques)
    @Query(value = "select NAT_ID idLigne, NAT_CODE codeLigne, NAT_LIBELLE libLigne from vb3_nature_eco_ligne n\n" +
            "where n.NAT_ID not in ( select a.TRTAG_NAT_ID from VB3_TRAITEMENT_AGENT a, vb3_AFFECTATION_AGENT b \n" +
            "where a.TRTAG_AGT_MAT=b.AFFAG_AGT_MAT\n" +
            "and AFFAG_CHAP_ID=:chapId\n" +
            "and AFFAG_EXPB_CODE=:exeCode and affag_date_cess is null)\n" +
            "and n.cade_code='2'\n" +
            "and n.NAT_TYPE='L'\n" +
            "order by n.NAT_CODE", nativeQuery = true)
    List<LigneBudgetDto> naturesEconomiques(@Param("exeCode") String exeCode, @Param("chapId") String chapId);

}