package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

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
import sn.sysbudgep.elaboration.dto.classe.TraitementsAgentDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.TraitementAgentDto;
import sn.sysbudgep.elaboration.dto.global.AgentsDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.TraitementAgentRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.TraitementAgentService;

import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sn.sysbudgep.elaboration.util.OracleResult.getInteger;
import static sn.sysbudgep.elaboration.util.OracleResult.getString;

@Service
public class TraitementAgentServiceImpl implements TraitementAgentService {

    private final TraitementAgentRepository traitementAgentRepository;
    private static final Logger logger =
            LoggerFactory.getLogger(MesureNouvelleServiceImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public TraitementAgentServiceImpl(TraitementAgentRepository traitementAgentRepository, JdbcTemplate jdbcTemplate) {
        this.traitementAgentRepository = traitementAgentRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    // Données traitement individuel d'un agent
    @Override
    public List<TraitementAgentDto> traitementIndividuel(ParametreRechercheDTO pr) {
        return traitementAgentRepository.traitementIndividuel(pr.getExeCode(), pr.getMatricule());
    }

    // Données traitement collectif
    @Override
    public List<TraitementAgentDto> traitementCollectif(ParametreRechercheDTO pr) {
        return traitementAgentRepository.traitementCollectif(pr.getExeCode(), pr.getSectionId(), pr.getChapId());
    }

    // Liste agents par chapId, natId
    @Override
    public List<AgentsDto> agentsChapNatId(ParametreRechercheDTO pr) {
        return traitementAgentRepository.agentsChapNatId(pr.getExeCode(), pr.getChapId(), pr.getNatId());
    }

    // Modification traitement collectif
    @Override
    public ResponseDto majTraitementAgent(List<TraitementsAgentDto> traitementAgentDto) throws SQLException, ParseException {
        ResponseDto responseDto = new ResponseDto();
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PK4_ELAB_TRAITEMENT_AGENT")
                .withProcedureName("p_maj_trait_agent")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("p_trait", Types.NUMERIC),
                        new SqlParameter("p_mont", Types.NUMERIC),
                        new SqlParameter("P_TEXTE_REF", Types.VARCHAR),
                        new SqlParameter("P_OBS", Types.VARCHAR),
                        new SqlParameter("p_acteur", Types.VARCHAR),
                        new SqlOutParameter("P_ETAT", Types.NUMERIC),
                        new SqlOutParameter("P_ERREUR", Types.VARCHAR)
                );

        for (TraitementsAgentDto tr : traitementAgentDto) {

            Map<String, Object> params = new HashMap<>();
            params.put("p_trait", tr.getTraitementId());
            params.put("p_mont", tr.getMontant());
            params.put("P_TEXTE_REF", tr.getTextReference());
            params.put("P_OBS", tr.getObservations());
            params.put("p_acteur", tr.getFoncatIdModif());

            Map<String, Object> result = call.execute(params);

            if (getInteger(result, "P_ETAT") == 0) {
                responseDto.setEtat(0);
                responseDto.setMessageErreur(
                        getString(result, "P_ERREUR"));
                return responseDto;
            }
        }
        responseDto.setEtat(1);
        return responseDto;
    }
    }