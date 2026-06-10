package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.AffectationAgentDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.classe.TraitementsAgentDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MajEmploisEffectifsDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.ChapitreEffectifsRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MajEmploisEffectifsService;

import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static sn.sysbudgep.elaboration.util.OracleResult.getInteger;
import static sn.sysbudgep.elaboration.util.OracleResult.getString;

@Service
public class MajEmploisEffectifsServiceImpl implements MajEmploisEffectifsService {

    private final ChapitreEffectifsRepository chapitreEffectifsRepository;
    private static final Logger logger =
            LoggerFactory.getLogger(MajEmploisEffectifsServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public MajEmploisEffectifsServiceImpl(ChapitreEffectifsRepository chapitreEffectifsRepository, JdbcTemplate jdbcTemplate) {
        this.chapitreEffectifsRepository = chapitreEffectifsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MajEmploisEffectifsDto> chapitreEffectifs(ParametreRechercheDTO pr) throws SQLException, ParseException {
        return chapitreEffectifsRepository.chapitreEffectifs(pr.getExeCode0(), pr.getExeCode(), pr.getProId(), pr.getIdEmploi());
    }

    // Intégration agent (ajouter agent sans chapitre ou flottants)
    @Override
    public ResponseDto integrerAgent(List<AffectationAgentDto> affectationAgentDto) throws SQLException, ParseException {
        ResponseDto responseDto = new ResponseDto();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = simpleDateFormat.format(new Date());

        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PK4_ELAB_AFFECTATION_AGENT")
                .withProcedureName("P_UPADTE_AFFEC")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("P_EXPB_CODE", Types.VARCHAR),
                        new SqlParameter("P_MAT", Types.VARCHAR),
                        new SqlParameter("P_CHAP_ID", Types.VARCHAR),
                        new SqlParameter("P_CHAP_ID_PREC", Types.NUMERIC),
                        new SqlParameter("p_SEC_ID", Types.VARCHAR),
                        new SqlParameter("P_SEC_ID_PREC", Types.VARCHAR),
                        new SqlParameter("P_TEXTE_REF", Types.VARCHAR),
                        new SqlParameter("P_OBS", Types.VARCHAR),
                        new SqlParameter("P_FONCID_MODIF", Types.VARCHAR),
                        new SqlParameter("P_AFFEC_TYP", Types.VARCHAR),
                        new SqlOutParameter("P_ETAT", Types.NUMERIC),
                        new SqlOutParameter("P_ERREUR", Types.VARCHAR)
                );

        for (AffectationAgentDto a : affectationAgentDto) {

            Map<String, Object> params = new HashMap<>();
            params.put("P_EXPB_CODE", a.getExeCode());
            params.put("P_MAT", a.getMatricule());
            params.put("P_CHAP_ID", a.getChapId());
            params.put("P_CHAP_ID_PREC", a.getChapIdPrecedant());
            params.put("p_SEC_ID", a.getSectionId());
            params.put("P_SEC_ID_PREC", a.getSectionIdPrecedant());
            params.put("P_TEXTE_REF", a.getTextReference());
            params.put("P_OBS", a.getObservations());
            params.put("P_FONCID_MODIF", a.getFoncatIdModif());
            params.put("P_AFFEC_TYP", 'S');

            Map<String, Object> result = call.execute(params);

            if (getInteger(result, "P_ETAT") == 0) {
                System.out.println("TTTTTTTTTTT");
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