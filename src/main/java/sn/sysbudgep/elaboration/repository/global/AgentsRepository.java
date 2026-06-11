package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

@Repository
public interface AgentsRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT\n" +
            "    e.EMPAG_CODE, e.EMPAG_LIB AS emploi,\n" +
            "    a.AFFAG_ID AS IdTraitement,\n" +
            "    a.AFFAG_AGT_MAT AS matricule,\n" +
            "    a.AFFAG_AGT_PRENOMS || ' ' || a.AFFAG_AGT_NOM AS nom,\n" +
            "    a.AFFAG_CHAP_ID chapId,\n" +
            "    a.AFFAG_CHAP_ID_PREC chapIdPrecedant,\n" +
            "    CASE \n" +
            "        WHEN a.AFFAG_AGT_CATEG = 'FP' THEN 'agent'\n" +
            "        ELSE 'contractuel'\n" +
            "    END AS statut,\n" +
            "    action.cop_code codeAction, action.cop_libelle libAction, \n" +
            "    activite.cop_code codeActivite, activite.cop_libelle libActivite,\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '661'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantTraitementsSalaires\",\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '662'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantPrimes\",\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '663'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantIndemnites\",\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '665'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantCotisationsSociales\",\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '666'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantPrestationsFamiliales\",\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '667'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantPrisesChargeMedicales\",\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '668'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantContractuels\",\n" +
            "    SUM(CASE \n" +
            "            WHEN SUBSTR(n.NAT_CODE,1,3) = '669'\n" +
            "            THEN b.TRTAG_MONT\n" +
            "            ELSE 0\n" +
            "        END) AS \"montantAutresChargesPersonnel\"\n" +
            "FROM vb3_affectation_agent a,\n" +
            "     vb3_traitement_agent b, vb3_emploi_agent e,\n" +
            "     vb3_nature_eco n, vb3_paragraphe p,\n" +
            "     tb_comp_prog action, tb_comp_prog activite\n" +
            "WHERE a.AFFAG_AGT_MAT = b.TRTAG_AGT_MAT\n" +
            "AND a.AFFAG_EMPAG_ID = e.EMPAG_ID\n" +
            "AND b.TRTAG_NAT_ID = n.NAT_ID\n" +
            "AND SUBSTR(n.NAT_CODE,1,3) = p.PRG_CODE\n" +
            "AND a.AFFAG_COP_ID = action.cop_id\n" +
            "AND a.AFFAG_ACTV_ID = activite.cop_id\n" +
            "AND a.AFFAG_CHAP_ID =:chapId\n" +
            "AND a.AFFAG_EXPB_CODE =:exeCode\n" +
            "and b.TRTAG_AGT_MAT LIKE '%'||:matricule\n" +
            "AND e.EMPAG_CODE LIKE '%'||:codeEmploi\n" +
            "GROUP BY\n" +
            "    e.EMPAG_CODE,\n" +
            "    e.EMPAG_LIB,\n" +
            "    a.AFFAG_ID,\n" +
            "    a.AFFAG_AGT_MAT,\n" +
            "    a.AFFAG_CHAP_ID,\n" +
            "    a.AFFAG_CHAP_ID_PREC,\n" +
            "    a.AFFAG_AGT_PRENOMS || ' ' || a.AFFAG_AGT_NOM,\n" +
            "    CASE \n" +
            "        WHEN a.AFFAG_AGT_CATEG = 'FP' THEN 'agent'\n" +
            "        ELSE 'contractuel'\n" +
            "    END,\n" +
            "    action.cop_code, action.cop_libelle, \n" +
            "    activite.cop_code, activite.cop_libelle\n" +
            "ORDER BY nom", nativeQuery = true)
    List<AgentsDto> agents(@Param("exeCode") String exeCode, @Param("chapId") String chapId,
                           @Param("matricule") String matricule, @Param("codeEmploi") String codeEmploi);

    // Agents flottants
    @Query(value = "select a.AFFAG_AGT_MAT matricule, a.AFFAG_AGT_PRENOMS prenom, a.AFFAG_AGT_NOM nom, \n" +
            "e.EMPAG_LIB emploi, a.AFFAG_OBS_SEC observation, a.AFFAG_TEXTE_REF_SEC texteReference,\n" +
            "a.AFFAG_SEC_ID_PREC sectionIdPrecedant, \n" +
            "CASE\n" +
            "    WHEN a.AFFAG_AGT_CATEG = 'FP' THEN 'agent'\n" +
            "        ELSE 'contractuel'\n" +
            "    END AS statut\n" +
            "FROM vb3_agent_flottant a\n" +
            "JOIN vb3_emploi_agent e\n" +
            "    ON a.AFFAG_EMPAG_ID = e.EMPAG_ID\n" +
            "ORDER BY a.AFFAG_AGT_PRENOMS", nativeQuery = true)
    List<AgentsDto> agentsFlottants();

    // Agents non affectés dans un chapitre
    @Query(value = "select a.AFFAG_AGT_MAT matricule, a.AFFAG_AGT_PRENOMS prenom, a.AFFAG_AGT_NOM nom, \n" +
            "e.EMPAG_LIB emploi, a.AFFAG_OBS_SEC observation, a.AFFAG_TEXTE_REF_SEC texteReference,\n" +
            "a.AFFAG_SEC_ID_PREC sectionIdPrecedant, \n" +
            "CASE\n" +
            "    WHEN a.AFFAG_AGT_CATEG = 'FP' THEN 'agent'\n" +
            "        ELSE 'contractuel'\n" +
            "    END AS statut\n" +
            "from VB3_AFFECTATION_AGENT a\n" +
            "JOIN vb3_emploi_agent e\n" +
            "    ON a.AFFAG_EMPAG_ID = e.EMPAG_ID\n" +
            "where AFFAG_SEC_ID=:sectionId and AFFAG_CHAP_ID is NULL\n" +
            "and  AFFAG_DATE_CESS is NULL and AFFAG_AGT_CATEG IN ('FP','CO','PL')\n" +
            "ORDER BY a.AFFAG_AGT_PRENOMS", nativeQuery = true)
    List<AgentsDto> agentsNonAffectesChap(@Param("sectionId") String sectionId);

    // Agents à intégrer ( agents sans chapitre et agents flottants)
    @Query(value = "select a.AFFAG_EXPB_CODE exeCode, a.AFFAG_AGT_MAT matricule, a.AFFAG_AGT_PRENOMS prenom, a.AFFAG_AGT_NOM nom, \n" +
            "e.EMPAG_LIB emploi, a.AFFAG_OBS_SEC observation, a.AFFAG_TEXTE_REF_SEC texteReference, a.AFFAG_SEC_ID sectionId,\n" +
            "a.AFFAG_SEC_ID_PREC sectionIdPrecedant, a.AFFAG_CHAP_ID chapId, a.AFFAG_CHAP_ID_PREC chapIdPrecedant,\n" +
            "CASE\n" +
            "    WHEN a.AFFAG_AGT_CATEG = 'FP' THEN 'agent'\n" +
            "        ELSE 'contractuel'\n" +
            "    END AS statut\n" +
            "from VB3_AFFECTATION_AGENT a\n" +
            "JOIN vb3_emploi_agent e\n" +
            "    ON a.AFFAG_EMPAG_ID = e.EMPAG_ID\n" +
            "where AFFAG_SEC_ID=:sectionId and AFFAG_CHAP_ID is NULL\n" +
            "and  AFFAG_DATE_CESS is NULL and AFFAG_AGT_CATEG IN ('FP','CO','PL')\n" +
            "UNION\n" +
            "select a.AFFAG_EXPB_CODE exeCode, a.AFFAG_AGT_MAT matricule, a.AFFAG_AGT_PRENOMS prenom, a.AFFAG_AGT_NOM nom, \n" +
            "e.EMPAG_LIB emploi, a.AFFAG_OBS_SEC observation, a.AFFAG_TEXTE_REF_SEC texteReference, a.AFFAG_SEC_ID sectionId,\n" +
            "a.AFFAG_SEC_ID_PREC sectionIdPrecedant, null chapId, null chapIdPrecedant,\n" +
            "CASE\n" +
            "    WHEN a.AFFAG_AGT_CATEG = 'FP' THEN 'agent'\n" +
            "        ELSE 'contractuel'\n" +
            "    END AS statut\n" +
            "FROM vb3_agent_flottant a\n" +
            "JOIN vb3_emploi_agent e\n" +
            "    ON a.AFFAG_EMPAG_ID = e.EMPAG_ID", nativeQuery = true)
    List<AgentsDto> agentsAIntegrer(@Param("sectionId") String sectionId);

}