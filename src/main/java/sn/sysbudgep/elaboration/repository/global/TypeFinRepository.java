package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.TypeFinDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface TypeFinRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT TFIN_ID AS tfinId, TFIN_CODE AS tfinCode, TFIN_LIB AS tfinLib, " +
            "TFIN_VALID AS tfinValid, TFIN_TYPRB_ID AS tfinTyprbId " +
            "FROM vb3_type_fin", nativeQuery = true)
    List<TypeFinDto> findAllTypeFin();
}