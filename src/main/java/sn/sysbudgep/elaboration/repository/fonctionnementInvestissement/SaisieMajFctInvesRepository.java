package sn.sysbudgep.elaboration.repository.fonctionnementInvestissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.ProgrammeDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.TypeFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.SourceFinDto;
import sn.sysbudgep.elaboration.dto.fonctionnementInvestissement.saisieMajFonctInves.CategorieDepenseDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface SaisieMajFctInvesRepository extends JpaRepository<SaisieMajFctInves, Integer> {

    @Query(value = "SELECT EXPB_CODE, EXPB_LIB, EXPB_DEBUT " +
            "FROM vb3_exercice_projet_bud " +
            "WHERE EXPB_EXE = :exe " +
            "AND EXPB_DEBUT IS NOT NULL", nativeQuery = true)
    ProjetDeBudgetDto findProjetDeBudget(@Param("exe") int exe);

    @Query(value = "SELECT DISTINCT pro_id AS proId, pro_code AS proCode, pro_libelle AS proLibelle, papp_ref AS pappRef " +
            "FROM vb3_programme, vb3_pap_programme " +
            "WHERE pro_id = papp_pro_id " +
            "AND pro_sec_id = :secId " +
            "AND papp_sec_id = :secId " +
            "AND papp_dppd_ref LIKE :exercice || '%' " +
            "AND PRO_VALIDITE_LEB = 'O' " +
            "ORDER BY pro_code", nativeQuery = true)
    List<ProgrammeDto> findProgrammes(@Param("secId") int secId, @Param("exercice") String exercice);

    @Query(value = "SELECT TFIN_ID AS tfinId, TFIN_CODE AS tfinCode, TFIN_LIB AS tfinLib, " +
            "TFIN_VALID AS tfinValid, TFIN_TYPRB_ID AS tfinTyprbId " +
            "FROM vb3_type_fin", nativeQuery = true)
    List<TypeFinDto> findAllTypeFin();

    @Query(value = "SELECT SFIN_CODE AS sfinCode, SFIN_LIB AS sfinLib, SFIN_FONCACT_ID AS sfinFoncactId, " +
            "SFIN_VALID AS sfinValid, SFIN_CODE_NBE AS sfinCodeNbe, SFIN_TYPRB_ID AS sfinTyprbId, " +
            "SFIN_BAILF_CODE AS sfinBailfCode, SFIN_TFIN_ID AS sfinTfinId " +
            "FROM vb3_source_fin " +
            "WHERE SFIN_VALID = 'O' " +
            "AND SFIN_TFIN_ID = :tfinId " +
            "ORDER BY SFIN_CODE_NBE", nativeQuery = true)
    List<SourceFinDto> findSourceFinByTypeFin(@Param("tfinId") int tfinId);

    @Query(value = "SELECT cade_code AS cadeCode, cade_lib AS cadeLib " +
            "FROM vb3_categorie_depense " +
            "WHERE cade_code IN (DECODE(SUBSTR(:proCode, 1, 1), '3', 2), '3', '4', '5', '6') " +
            "ORDER BY cade_code", nativeQuery = true)
    List<CategorieDepenseDto> findCategoriesDepense(@Param("proCode") String proCode);
}