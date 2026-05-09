package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.SourceFinDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface SourceFinRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT SFIN_CODE AS sfinCode, SFIN_LIB AS sfinLib, SFIN_FONCACT_ID AS sfinFoncactId, " +
            "SFIN_VALID AS sfinValid, SFIN_CODE_NBE AS sfinCodeNbe, SFIN_TYPRB_ID AS sfinTyprbId, " +
            "SFIN_BAILF_CODE AS sfinBailfCode, SFIN_TFIN_ID AS sfinTfinId " +
            "FROM vb3_source_fin " +
            "WHERE SFIN_VALID = 'O' " +
            "AND SFIN_TFIN_ID = :tfinId " +
            "ORDER BY SFIN_CODE_NBE", nativeQuery = true)
    List<SourceFinDto> findSourceFinByTypeFin(@Param("tfinId") String tfinId);
}