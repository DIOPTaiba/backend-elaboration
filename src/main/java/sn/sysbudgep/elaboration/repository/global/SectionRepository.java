package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.SectionDto;
import sn.sysbudgep.elaboration.dto.global.TypeFinDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<SaisieMajFctInves, String> {

    // Liste de toutes les sections valides
    @Query(value = "SELECT SEC_ID sectionId, SEC_CODE sectionCode, SEC_LIBELLE sectionLib\n" +
            "FROM vb3_section\n" +
            "WHERE SEC_VALID = 'O'\n" +
            "ORDER BY SEC_LIBELLE", nativeQuery = true)
    List<SectionDto> listeSection();
}