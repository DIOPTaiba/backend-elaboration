package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.CategorieDepenseDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface CategorieDepenseRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT cade_code AS cadeCode, cade_lib AS cadeLib " +
            "FROM vb3_categorie_depense " +
            "WHERE cade_code IN (DECODE(SUBSTR(:proCode, 1, 1), '3', 2), '3', '4', '5', '6') " +
            "ORDER BY cade_code", nativeQuery = true)
    List<CategorieDepenseDto> findCategoriesDepense(@Param("proCode") String proCode);
}