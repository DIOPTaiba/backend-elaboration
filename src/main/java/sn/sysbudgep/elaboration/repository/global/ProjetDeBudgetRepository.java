package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

@Repository
public interface ProjetDeBudgetRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT EXPB_CODE, EXPB_LIB, EXPB_DEBUT " +
            "FROM vb3_exercice_projet_bud " +
            "WHERE EXPB_EXE = :exe " +
            "AND EXPB_DEBUT IS NOT NULL", nativeQuery = true)
    ProjetDeBudgetDto findProjetDeBudget(@Param("exe") int exe);
}