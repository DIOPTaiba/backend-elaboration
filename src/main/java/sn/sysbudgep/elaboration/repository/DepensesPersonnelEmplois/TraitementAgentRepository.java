package sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

public interface TraitementAgentRepository extends JpaRepository<SaisieMajFctInves, String> {
    // Données traitement individuel d'un agent
    @Query(value = "select p.PRG_CODE||'-'||p.PRG_LIBELLE paragraphe, n.NAT_CODE codeLigne, n.NAT_LIBELLE libLigne, a.AFFAG_OBS_SEC observation, a.AFFAG_TEXTE_REF_SEC texteReference, b.TRTAG_MONT montant\n" +
            "from vb3_affectation_agent a,vb3_traitement_agent b,vb3_emploi_agent e,vb3_nature_eco n,vb3_paragraphe p\n" +
            "where a.AFFAG_AGT_MAT=b.TRTAG_AGT_MAT\n" +
            "and a.AFFAG_EMPAG_ID=e.EMPAG_ID\n" +
            "and b.TRTAG_NAT_ID=n.NAT_ID\n" +
            "and substr(n.NAT_CODE,1,3)=p.PRG_CODE\n" +
            "and b.TRTAG_AGT_MAT=:matricule\n" +
            "and a.AFFAG_EXPB_CODE=:exeCode\n" +
            "order by n.NAT_CODE", nativeQuery = true)
    List<TraitementAgentDto> traitementIndividuel(@Param("exeCode") String exeCode, @Param("matricule") String matricule);

    // Données traitement collectif
    @Query(value = "SELECT\n" +
            "    n.NAT_ID idLigne, n.NAT_CODE codeLigne,\n" +
            "    n.NAT_LIBELLE libLigne, NVL(bc.BUDCL_LFI,0) montantLFIExeCode0,\n" +
            "    NVL(l.BPCL_SVR,0) creditsReevalues, NVL(l.BPCL_MN,0) mesuresNouvelles,\n" +
            "    NVL(l.BPCL_SVR,0) + NVL(l.BPCL_MN,0) creditsInscrits\n" +
            "FROM vb3_budget_pers_chap_ligne l\n" +
            "INNER JOIN vb3_nature_eco n\n" +
            "    ON l.BPCL_NAT_ID = n.NAT_ID\n" +
            "LEFT JOIN vb3_budget_chap_ligne bc\n" +
            "    ON bc.BUDCL_NAT_ID   = l.BPCL_NAT_ID\n" +
            "   AND bc.BUDCL_CHAP_ID  = l.BPCL_CHAP_ID\n" +
            "   AND bc.BUDCL_EXPB_CODE = :exeCode\n" +
            "   AND bc.BUDCL_VERS_CODE =\n" +
            "       fb3_version_sec_courante(:exeCode, :sectionId)\n" +
            "   AND bc.BUDCL_SFIN_CODE = 'TRE'\n" +
            "   AND bc.BUDCL_BAILF_CODE = 1\n" +
            "WHERE l.BPCL_EXPB_CODE = :exeCode\n" +
            "AND l.BPCL_CHAP_ID = :chapId\n" +
            "ORDER BY n.NAT_LIBELLE", nativeQuery = true)
    List<TraitementAgentDto> traitementCollectif(@Param("exeCode") String exeCode, @Param("sectionId") String sectionId, @Param("chapId") String chapId);

    // Liste agents par chapId, natId
    @Query(value = "select t.TRTAG_ID idTraitement, t.TRTAG_AGT_MAT matricule, a.AFFAG_AGT_PRENOMS prenom, a.AFFAG_AGT_NOM nom,\n" +
            "e.EMPAG_LIB emploi, t.TRTAG_MONT montant\n" +
            "from VB3_TRAITEMENT_AGENT t, vb3_affectation_agent a, vb3_emploi_agent e\n" +
            "where a.AFFAG_AGT_MAT = t.TRTAG_AGT_MAT\n" +
            "and a.AFFAG_EMPAG_ID = e.EMPAG_ID\n" +
            "and trtag_expb_code=:exeCode \n" +
            "and trtag_nat_id=:natId\n" +
            "and trtag_agt_mat in (select AFFAG_AGT_MAT from vb3_AFFECTATION_AGENT \n" +
            "        where AFFAG_CHAP_ID=:chapId \n" +
            "        and AFFAG_EXPB_CODE=:exeCode \n" +
            "        and affag_date_cess is null)\n" +
            "ORDER BY a.AFFAG_AGT_PRENOMS", nativeQuery = true)
    List<AgentsDto> agentsChapNatId(@Param("exeCode") String exeCode, @Param("chapId") String chapId, @Param("natId") String natId);

}
