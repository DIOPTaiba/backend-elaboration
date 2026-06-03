package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MesureNouvelleDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface MesureNouvelleService {

        // Liste mesure nouvelles
        List<MesureNouvelleDto> mesuresNouvelles(ParametreRechercheDTO pr);

        // Insertion Mesures nouvelles
        ResponseDto insertMesuresNouvelles(ParametreRechercheDTO pr) throws SQLException, ParseException;

}
