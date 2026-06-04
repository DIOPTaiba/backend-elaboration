package sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

import java.util.List;

public interface TraitementAgentRepository extends JpaRepository<SaisieMajFctInves, String> {
    @Query(value = "select p.PRG_CODE||'-'||p.PRG_LIBELLE paragraphe,n.NAT_CODE||'-'||n.NAT_LIBELLE ligneDepense, a.AFFAG_OBS_SEC observation, a.AFFAG_TEXTE_REF_SEC texteReference, b.TRTAG_MONT montant\n" +
            "from vb3_affectation_agent a,vb3_traitement_agent b,vb3_emploi_agent e,vb3_nature_eco n,vb3_paragraphe p\n" +
            "where a.AFFAG_AGT_MAT=b.TRTAG_AGT_MAT\n" +
            "and a.AFFAG_EMPAG_ID=e.EMPAG_ID\n" +
            "and b.TRTAG_NAT_ID=n.NAT_ID\n" +
            "and substr(n.NAT_CODE,1,3)=p.PRG_CODE\n" +
            "and b.TRTAG_AGT_MAT=:matricule\n" +
            "and a.AFFAG_EXPB_CODE=:exeCode\n" +
            "order by n.NAT_CODE", nativeQuery = true)
    List<TraitementAgentDto> traitementAgent (@Param("exeCode") String exeCode, @Param("matricule") String matricule);
}
