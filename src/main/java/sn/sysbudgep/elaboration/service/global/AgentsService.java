package sn.sysbudgep.elaboration.service.global;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface AgentsService {
    List<AgentsDto> agents(ParametreRechercheDTO pr);

    // Ajouter agent
    ResponseDto ajouterAgent(ParametreRechercheDTO pr) throws SQLException, ParseException;

}