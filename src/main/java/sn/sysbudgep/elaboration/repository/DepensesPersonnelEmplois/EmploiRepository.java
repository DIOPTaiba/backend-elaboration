package sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

public interface EmploiRepository  extends JpaRepository<SaisieMajFctInves, String> {
    @Query(value = "select EMPAG_ID idEmploi, EMPAG_CODE codeEmploi, EMPAG_LIB libelleEmploi\n" +
            "from VB3_EMPLOI_AGENT\n" +
            "order by EMPAG_CODE", nativeQuery = true)
    List<EmploiDto> findAllEmplois();
}
