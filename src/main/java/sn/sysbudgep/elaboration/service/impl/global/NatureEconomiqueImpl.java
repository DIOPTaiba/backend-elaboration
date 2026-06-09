package sn.sysbudgep.elaboration.service.impl.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.repository.global.AgentsRepository;
import sn.sysbudgep.elaboration.repository.global.NatureEconomiqueRepository;
import sn.sysbudgep.elaboration.service.global.AgentsService;
import sn.sysbudgep.elaboration.service.global.NatureEconomiqueService;
import sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois.MajEmploisEffectifsServiceImpl;

import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sn.sysbudgep.elaboration.util.OracleResult.getInteger;
import static sn.sysbudgep.elaboration.util.OracleResult.getString;

@Service
public class NatureEconomiqueImpl implements NatureEconomiqueService {

    private final NatureEconomiqueRepository natureEconomiqueRepository;

    public NatureEconomiqueImpl(NatureEconomiqueRepository natureEconomiqueRepository) {
        this.natureEconomiqueRepository = natureEconomiqueRepository;
    }

    // Lignes budget (Natures économiques) dont aucun agent du chapitre ne bénéficie
    @Override
    public List<LigneBudgetDto> naturesEconomiques(ParametreRechercheDTO pr) {
        return natureEconomiqueRepository.naturesEconomiques(pr.getExeCode(), pr.getChapId());
    }
}