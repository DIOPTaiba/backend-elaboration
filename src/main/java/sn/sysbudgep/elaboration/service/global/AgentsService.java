package sn.sysbudgep.elaboration.service.global;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.global.Agents;
import sn.sysbudgep.elaboration.dto.global.CategorieDepenseDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface AgentsService {
    List<Agents> agents(ParametreRechercheDTO pr);

    // Ajouter agent
    ResponseDto ajouterAgent(ParametreRechercheDTO pr) throws SQLException, ParseException;

}