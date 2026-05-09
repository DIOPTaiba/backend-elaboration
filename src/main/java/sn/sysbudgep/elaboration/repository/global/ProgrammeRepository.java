package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.ProgrammeDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface ProgrammeRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT DISTINCT pro_id AS proId, pro_code AS proCode, pro_libelle AS proLibelle, papp_ref AS pappRef " +
            "FROM vb3_programme, vb3_pap_programme " +
            "WHERE pro_id = papp_pro_id " +
            "AND pro_sec_id = :secId " +
            "AND papp_sec_id = :secId " +
            "AND papp_dppd_ref LIKE :exercice || '%' " +
            "AND PRO_VALIDITE_LEB = 'O' " +
            "ORDER BY pro_code", nativeQuery = true)
    List<ProgrammeDto> findProgrammes(@Param("secId") String secId, @Param("exercice") String exercice);
}