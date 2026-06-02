package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.ActiviteDto;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.SaisieMajFctInvesRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static sn.sysbudgep.elaboration.util.OracleResult.*;

@Service
public class SaisieMajFctInvesServiceImpl implements SaisieMajFctInvesService {

    private final SaisieMajFctInvesRepository saisieMajFctInvesRepository;
    private static final Logger logger =
            LoggerFactory.getLogger(SaisieMajFctInvesServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public SaisieMajFctInvesServiceImpl(SaisieMajFctInvesRepository saisieMajFctInvesRepository, JdbcTemplate jdbcTemplate) {
        this.saisieMajFctInvesRepository = saisieMajFctInvesRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MontantAECPDto montantsAECPLigne(ParametreRechercheDTO pr) {

        MontantAECPDto dto = new MontantAECPDto();

        try {

            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PK3_LIGNE_ENVELOPPE_PROG")
                    .withProcedureName("p_mont_env")
                    // si plusieurs procédures avec même nom dans la BD oracle
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            // =====================
                            // IN
                            // =====================
                            new SqlParameter("p_exe", Types.NUMERIC),
                            new SqlParameter("p_sec_id", Types.VARCHAR),
                            new SqlParameter("p_prog", Types.VARCHAR),
                            new SqlParameter("p_categ", Types.VARCHAR),
                            new SqlParameter("psfin_code", Types.VARCHAR),

                            // =====================
                            // OUT
                            // =====================
                            new SqlOutParameter("p_mont_n1", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n2", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n3", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n1_ae", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n2_ae", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n3_ae", Types.NUMERIC)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("p_exe", pr.getExe());
            params.put("p_sec_id", pr.getSectionId());
            params.put("p_prog", pr.getProId());
            params.put("p_categ", pr.getCadeCode());
            params.put("psfin_code", pr.getSfinCode());

            Map<String, Object> result = call.execute(params);

            // =====================
            // MAPPING PROPRE
            // =====================
            dto.setMontantN1CP(getBigDecimal(result, "p_mont_n1"));
            dto.setMontantN2CP(getBigDecimal(result, "p_mont_n2"));
            dto.setMontantN3CP(getBigDecimal(result, "p_mont_n3"));
            dto.setMontantN1AE(getBigDecimal(result, "p_mont_n1_ae"));
            dto.setMontantN2AE(getBigDecimal(result, "p_mont_n2_ae"));
            dto.setMontantN3AE(getBigDecimal(result, "p_mont_n3_ae"));

        } catch (DataAccessException e) {
            logger.error("Erreur base de données procédure PK3_LIGNE_ENVELOPPE_PROG.p_mont_env()", e);
            throw new RuntimeException(
                    "Erreur récupération montants AE/CP", e
            );
        }
        return dto;
    }

    @Override
    public MontantAECPDto montantsAECPProgramme(ParametreRechercheDTO pr)  {
        MontantAECPDto dto = new MontantAECPDto();

        try {

            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PK3_PAP_PROGRAMME")
                    .withProcedureName("p_credits_saisie")
                    // si plusieurs procédures avec même nom dans la BD oracle
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            // =====================
                            // IN
                            // =====================
                            new SqlParameter("p_exe", Types.NUMERIC),
                            new SqlParameter("p_sec_id", Types.VARCHAR),
                            new SqlParameter("p_prog", Types.VARCHAR),
                            new SqlParameter("p_categ", Types.VARCHAR),
                            new SqlParameter("psfin_code", Types.VARCHAR),

                            // =====================
                            // OUT
                            // =====================
                            new SqlOutParameter("p_mont_n1", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n2", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n3", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n1_ae", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n2_ae", Types.NUMERIC),
                            new SqlOutParameter("p_mont_n3_ae", Types.NUMERIC)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("p_exe", pr.getExe());
            params.put("p_sec_id", pr.getSectionId());
            params.put("p_prog", pr.getProId());
            params.put("p_categ", pr.getCadeCode());
            params.put("psfin_code", pr.getSfinCode());

            Map<String, Object> result = call.execute(params);

            // =====================
            // MAPPING PROPRE
            // =====================
            dto.setMontantN1CP(getBigDecimal(result, "p_mont_n1"));
            dto.setMontantN2CP(getBigDecimal(result, "p_mont_n2"));
            dto.setMontantN3CP(getBigDecimal(result, "p_mont_n3"));
            dto.setMontantN1AE(getBigDecimal(result, "p_mont_n1_ae"));
            dto.setMontantN2AE(getBigDecimal(result, "p_mont_n2_ae"));
            dto.setMontantN3AE(getBigDecimal(result, "p_mont_n3_ae"));

        } catch (DataAccessException e) {
            logger.error("Erreur base de données procédure PK3_PAP_PROGRAMME.p_credits_saisie()", e);
            throw new RuntimeException(
                    "Erreur récupération montants AE/CP", e
            );
        }

        return dto;
    }

    @Override
    public List<LigneBudgetDto> lignesBudget(ParametreRechercheDTO pr) {
        return saisieMajFctInvesRepository.ligneBudget(pr.getExeCode(), pr.getChapId());
    }

    @Override
    public List<ActiviteDto> listeActiviteSaisie(ParametreRechercheDTO pr) {
        return saisieMajFctInvesRepository.listeActiviteSaisie(pr.getExeCode(), pr.getChapId());
    }

    @Override
    public List<LigneBudgetDto> ligneSaisie(ParametreRechercheDTO pr) {
        return saisieMajFctInvesRepository.ligneSaisie(pr.getCadeCode(), pr.getBudcCode(), pr.getChapId(), pr.getSfinCode());
    }
    @Override
    public ResponseDto insertLigneBudget(ParametreRechercheDTO pr) throws SQLException, ParseException {
        ResponseDto responseDto = new ResponseDto();
        try {
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PK4_ELAB_LIGNE_BUDGET_COMP")
                    .withProcedureName("p_insertion")
                    // si plusieurs procédures avec même nom dans la BD oracle
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            new SqlOutParameter("P_BUC_CODE", Types.VARCHAR),
                            new SqlParameter("P_LBUC_SEC_ID", Types.VARCHAR),
                            new SqlParameter("P_LBUC_BUDC_CODE", Types.VARCHAR),
                            new SqlParameter("P_LBUC_CHAP_ID", Types.VARCHAR),
                            new SqlParameter("P_LBUC_NAT_ID", Types.NUMERIC),
                            new SqlParameter("P_LBUC_CADE_CODE", Types.VARCHAR),
                            new SqlParameter("P_LBUC_SFIN_CODE", Types.VARCHAR),
                            new SqlParameter("P_LBUC_SFIN_CODE_NEW", Types.VARCHAR),
                            new SqlParameter("P_LBUC_BAILF_CODE", Types.NUMERIC),
                            new SqlParameter("P_LBUC_CP_1_PREC", Types.NUMERIC),
                            new SqlParameter("P_LBUC_CP_1", Types.NUMERIC),
                            new SqlParameter("P_LBUC_AE_ANT", Types.NUMERIC),
                            new SqlParameter("P_LBUC_AE_1_PREC", Types.NUMERIC),
                            new SqlParameter("P_LBUC_AE_1", Types.NUMERIC),
                            new SqlParameter("P_LBUC_FONCACT_ID", Types.VARCHAR),
                            new SqlOutParameter("p_etat", Types.NUMERIC),
                            new SqlOutParameter("p_erreur", Types.VARCHAR)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("P_LBUC_SEC_ID", pr.getSectionId());
            params.put("P_LBUC_BUDC_CODE", pr.getBudcCode());
            params.put("P_LBUC_CHAP_ID", pr.getChapId());
            params.put("P_LBUC_NAT_ID", pr.getNatIdNumber());
            params.put("P_LBUC_CADE_CODE", pr.getCadeCode());
            params.put("P_LBUC_SFIN_CODE", pr.getSfinCode());
            params.put("P_LBUC_SFIN_CODE_NEW", pr.getSfinCodeNew());
            params.put("P_LBUC_BAILF_CODE", pr.getBailfCode());
            params.put("P_LBUC_CP_1_PREC", pr.getCp1Prec());
            params.put("P_LBUC_CP_1", pr.getCp1());
            params.put("P_LBUC_AE_ANT", pr.getAeAnt());
            params.put("P_LBUC_AE_1_PREC", pr.getAe1Prec());
            params.put("P_LBUC_AE_1", pr.getAe1());
            params.put("P_LBUC_FONCACT_ID", pr.getFoncatId());

            Map<String, Object> result = call.execute(params);

            // =====================
            // MAPPING
            // =====================
            responseDto.setNumero(getString(result,"P_BUC_CODE"));
            responseDto.setEtat(getInteger(result, "p_etat"));
            responseDto.setMessageErreur(getString(result, "p_erreur"));

        } catch (DataAccessException e) {
            logger.error("Erreur base de données procédure PK4_ELAB_LIGNE_BUDGET_COMP.p_insertion", e);
            throw new RuntimeException(
                    "Erreur récupération résultat", e
            );
        }

        return responseDto;
    }

    @Override
    public ResponseDto updateLigneBudget(String lbucCode, ParametreRechercheDTO pr) throws SQLException, ParseException {
        ResponseDto dto = new ResponseDto();
        try {
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PK4_ELAB_LIGNE_BUDGET_COMP")
                    .withProcedureName("p_update")
                    // si plusieurs procédures avec même nom dans la BD oracle
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            new SqlParameter("P_LBUC_CODE", Types.VARCHAR),
                            new SqlParameter("P_LBUC_CP_1", Types.NUMERIC),
                            new SqlParameter("P_LBUC_AE_1", Types.NUMERIC),
                            new SqlParameter("P_LBUC_CP_MN", Types.NUMERIC),
                            new SqlParameter("P_LBUC_AE_MN", Types.NUMERIC),
                            new SqlParameter("P_LBUC_FONCACT_ID", Types.VARCHAR),
                            new SqlOutParameter("p_etat", Types.NUMERIC),
                            new SqlOutParameter("p_erreur", Types.VARCHAR)
                    );

            Map<String, Object> params = new HashMap<>();
            params.put("P_LBUC_CODE", lbucCode);
            params.put("P_LBUC_CP_1", pr.getCp1());
            params.put("P_LBUC_AE_1", pr.getAe1());
            params.put("P_LBUC_CP_MN", pr.getCpMn());
            params.put("P_LBUC_AE_MN", pr.getAeMn());
            params.put("P_LBUC_FONCACT_ID", pr.getFoncatId());

            Map<String, Object> result = call.execute(params);

            // =====================
            // MAPPING
            // =====================
            dto.setEtat(getInteger(result, "p_etat"));
            dto.setMessageErreur(getString(result, "p_erreur"));

        } catch (DataAccessException e) {
            logger.error("Erreur base de données procédure PK4_ELAB_LIGNE_BUDGET_COMP.p_update", e);
            throw new RuntimeException(
                    "Erreur récupération résultat", e
            );
        }

        return dto;
    }

    @Override
    public boolean supprimerLigneBudget(String lbucCode) {
        saisieMajFctInvesRepository.supprimerLigneBudget(lbucCode);
        return true;
    }

}