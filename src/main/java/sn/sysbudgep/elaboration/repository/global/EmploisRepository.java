package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.Agents;
import sn.sysbudgep.elaboration.dto.global.Emplois;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface EmploisRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "select EMPAG_ID idEmploi, EMPAG_CODE codeEmploi, EMPAG_LIB libemploi from vb3_emploi_agent ORDER BY EMPAG_LIB", nativeQuery = true)
    List<Emplois> emplois();

}