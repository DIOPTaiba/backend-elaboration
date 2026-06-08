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
import sn.sysbudgep.elaboration.repository.global.AgentsRepository;
import sn.sysbudgep.elaboration.service.global.AgentsService;
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
public class AgentsImpl implements AgentsService {

    private final AgentsRepository agentsRepository;
    private static final Logger logger =
            LoggerFactory.getLogger(MajEmploisEffectifsServiceImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public AgentsImpl(AgentsRepository agentsRepository, JdbcTemplate jdbcTemplate) {
        this.agentsRepository = agentsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AgentsDto> agents(ParametreRechercheDTO pr) {
        return agentsRepository.agents(pr.getExeCode(), pr.getChapId(), pr.getMatricule(), pr.getCodeEmploi());
    }

    @Override
    public ResponseDto ajouterAgent(ParametreRechercheDTO pr) throws SQLException, ParseException {
        ResponseDto responseDto = new ResponseDto();
        try {
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("PB4_ELAB_INSERTION_AGENT")
                    // si plusieurs procédures avec même nom dans la BD oracle
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            new SqlParameter("p_expb_code", Types.VARCHAR),
                            new SqlParameter("p_matricule", Types.VARCHAR),
                            new SqlParameter("p_nom", Types.VARCHAR),
                            new SqlParameter("p_prenom", Types.VARCHAR),
                            new SqlParameter("p_sec_id", Types.VARCHAR),
                            new SqlParameter("p_chap_id", Types.VARCHAR),
                            new SqlParameter("p_emp_id", Types.VARCHAR),
                            new SqlParameter("p_fonc_act_id", Types.VARCHAR),
                            new SqlOutParameter("p_etat", Types.NUMERIC),
                            new SqlOutParameter("p_erreur", Types.VARCHAR)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("p_expb_code", pr.getExeCode());
            params.put("p_matricule", pr.getMatricule());
            params.put("p_nom", pr.getNom());
            params.put("p_prenom", pr.getPrenom());
            params.put("p_sec_id", pr.getSectionId());
            params.put("p_chap_id", pr.getChapId());
            params.put("p_emp_id", pr.getIdEmploi());
            params.put("p_fonc_act_id", pr.getFoncatId());

            Map<String, Object> result = call.execute(params);

            // =====================
            // MAPPING result
            // =====================
            responseDto.setEtat(getInteger(result, "p_etat"));
            responseDto.setMessageErreur(getString(result, "p_erreur"));

        } catch (DataAccessException e) {
            logger.error("Erreur base de données procédure PB4_ELAB_INSERTION_AGENT", e);
            throw new RuntimeException(
                    "Erreur récupération résultat", e
            );
        }

        return responseDto;
    }
}