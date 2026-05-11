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
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.SaisieMajFctInvesRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            logger.error("Erreur base de données procédure p_mont_env", e);
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
            logger.error("Erreur base de données procédure p_mont_env", e);
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

    // pour gérer les null
    private BigDecimal getBigDecimal(Map<String, Object> result, String key) {
        return Optional.ofNullable((BigDecimal) result.get(key))
                .orElse(BigDecimal.ZERO);
    }
}