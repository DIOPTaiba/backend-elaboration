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
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MesureNouvelleDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.MesureNouvelleRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MesureNouvelleService;

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
public class MesureNouvelleServiceImpl implements MesureNouvelleService {

    private final MesureNouvelleRepository mesureNouvelleRepository;
    private static final Logger logger =
            LoggerFactory.getLogger(MesureNouvelleServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public MesureNouvelleServiceImpl(MesureNouvelleRepository mesureNouvelleRepository, JdbcTemplate jdbcTemplate) {
        this.mesureNouvelleRepository = mesureNouvelleRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MesureNouvelleDto> mesuresNouvelles(ParametreRechercheDTO pr) {
        return mesureNouvelleRepository.mesuresNouvelles(pr.getExeCode(), pr.getChapId());
    }

    @Override
    public ResponseDto insertMesuresNouvelles(ParametreRechercheDTO pr) throws SQLException, ParseException {
        ResponseDto responseDto = new ResponseDto();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateInString = simpleDateFormat.format(new Date());

            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PK4_ELAB_MES_NOUV_PERS")
                    .withProcedureName("P_INSERTION")
                    // si plusieurs procédures avec même nom dans la BD oracle
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            new SqlParameter("P_MNP_EXPB_CODE", Types.VARCHAR),
                            new SqlParameter("P_MNP_CHAP_ID", Types.VARCHAR),
                            new SqlParameter("P_MNP_EMP_ID", Types.NUMERIC),
                            new SqlParameter("P_MNP_SEC_ID", Types.VARCHAR),
                            new SqlParameter("P_MNP_EFFECTIF", Types.NUMERIC),
                            new SqlParameter("P_MNP_OBS", Types.VARCHAR),
                            new SqlParameter("P_MNP_FONC_SAISI", Types.VARCHAR),
                            new SqlParameter("P_MNP_DATE_SAISIE", Types.DATE),
                            new SqlParameter("P_MNP_date_modif", Types.DATE),
                            new SqlParameter("P_MNP_fonc_modif", Types.VARCHAR),
                            new SqlOutParameter("P_ETAT", Types.NUMERIC),
                            new SqlOutParameter("P_ERREUR", Types.VARCHAR)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("P_MNP_EXPB_CODE", pr.getExeCode());
            params.put("P_MNP_CHAP_ID", pr.getChapId());
            params.put("P_MNP_EMP_ID", pr.getIdEmploi());
            params.put("P_MNP_SEC_ID", pr.getSectionId());
            params.put("P_MNP_EFFECTIF", pr.getEffectif());
            params.put("P_MNP_OBS", pr.getObservations());
            params.put("P_MNP_FONC_SAISI", pr.getFoncatId());
            params.put("P_MNP_DATE_SAISIE", dateInString);
            params.put("P_MNP_date_modif", null);
            params.put("P_MNP_fonc_modif", pr.getFoncatIdModif());

            Map<String, Object> result = call.execute(params);

            // =====================
            // MAPPING result
            // =====================
            responseDto.setEtat(getInteger(result, "P_ETAT"));
            responseDto.setMessageErreur(getString(result, "P_ERREUR"));

        } catch (DataAccessException e) {
            logger.error("Erreur base de données procédure PK4_ELAB_MES_NOUV_PERS.p_insertion", e);
            throw new RuntimeException(
                    "Erreur récupération résultat", e
            );
        }

        return responseDto;
    }
}