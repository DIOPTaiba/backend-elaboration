package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.AffectationAgentDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MajEmploisEffectifsDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Service
public interface MajEmploisEffectifsService {
    // Chapitre et effectifs
    List<MajEmploisEffectifsDto> chapitreEffectifs(ParametreRechercheDTO pr) throws SQLException, ParseException;

    // Intégration agent (ajouter agent sans chapitre ou flottants)
    ResponseDto updateAffectation(List<AffectationAgentDto> affectationAgentDto) throws SQLException, ParseException;

    // Maj Affectation chapitre
    ResponseDto majAffectationChapitre(AffectationAgentDto affectationAgentDto) throws SQLException, ParseException;

}