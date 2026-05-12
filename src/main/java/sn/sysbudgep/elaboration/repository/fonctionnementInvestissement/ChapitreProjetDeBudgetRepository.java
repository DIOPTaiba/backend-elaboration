package sn.sysbudgep.elaboration.repository.fonctionnementInvestissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.ChapitreDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface ChapitreProjetDeBudgetRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT chap_id AS chapId, chap_code AS chapCode, chap_lib AS chapLib, " +
            "SUM(c.lbuc_ae_1) AS ae, SUM(c.lbuc_cp_1) AS cp " +
            "FROM vb3_chapitre " +
            "JOIN vb3_ligne_budget_comp_lfi c ON chap_id = c.lbuc_chap_id " +
            "WHERE chap_sec_id_leb = :secId " +
            "AND (:sfinCode IS NULL OR c.lbuc_sfin_code = :sfinCode) " +
            "AND chap_id IN ( " +
            "    SELECT PC_CHAP_ID FROM vb3_prog_chapitre " +
            "    WHERE PC_PRO_ID = :proId AND PC_VALIDE = 'O' " +
            ") " +
            "AND (chap_code_ptip IS NOT NULL OR :proCode LIKE '3%') " +
            "GROUP BY chap_id, chap_code, chap_lib " +
            "ORDER BY chap_code", nativeQuery = true)
    List<ChapitreDto> findChapitresInvestissement(
            @Param("secId") String secId,
            @Param("sfinCode") String sfinCode,
            @Param("proId") String proId,
            @Param("proCode") String proCode
    );

    @Query(value = "SELECT chap_id AS chapId, chap_code AS chapCode, chap_lib AS chapLib, " +
            "SUM(c.lbuc_ae_1) AS ae, SUM(c.lbuc_cp_1) AS cp " +
            "FROM vb3_chapitre " +
            "JOIN vb3_ligne_budget_comp_lfi c ON chap_id = c.lbuc_chap_id " +
            "WHERE chap_sec_id_leb = :secId " +
            "AND (:sfinCode IS NULL OR c.lbuc_sfin_code = :sfinCode)" +
            "AND chap_id IN ( " +
            "    SELECT PC_CHAP_ID FROM vb3_prog_chapitre " +
            "    WHERE PC_PRO_ID = :proId AND PC_VALIDE = 'O' " +
            ") " +
            "AND chap_code_ptip IS NULL " +
            "GROUP BY chap_id, chap_code, chap_lib " +
            "ORDER BY chap_code", nativeQuery = true)
    List<ChapitreDto> findChapitreFonctionnement(
            @Param("secId") String secId,
            @Param("sfinCode") String sfinCode,
            @Param("proId") String proId
    );
}