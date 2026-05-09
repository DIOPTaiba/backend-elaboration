package sn.sysbudgep.elaboration.service.impl.fonctionnementInvestissement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.MontantAECPDto;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.SaisieMajFctInvesRepository;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;
import sn.sysbudgep.elaboration.util.GetConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;

@Service
public class SaisieMajFctInvesServiceImpl implements SaisieMajFctInvesService {
    private static final Logger logger = LoggerFactory.getLogger(SaisieMajFctInvesService.class);
    Connection con = null;
    CallableStatement stmt;

    private final SaisieMajFctInvesRepository saisieMajFctInvesRepository;

    public SaisieMajFctInvesServiceImpl(SaisieMajFctInvesRepository saisieMajFctInvesRepository) {
        this.saisieMajFctInvesRepository = saisieMajFctInvesRepository;
    }

    @Override
    public MontantAECPDto repositionnerDelegationCredits(ParametreRechercheDTO pr) throws SQLException, ParseException {
        ResponseDto responseDto = new ResponseDto();
        MontantAECPDto montantAECPDto = new MontantAECPDto();
        try {
            con = GetConnection.getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareCall("{ call PK3_LIGNE_ENVELOPPE_PROG.p_mont_env(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            stmt.setInt(1, pr.getExe());
            stmt.setString(2, pr.getSectionId());
            stmt.setString(3, pr.getProId());
            stmt.setString(4, pr.getCadeCode());
            stmt.setString(5, pr.getSfinCode());
            stmt.registerOutParameter(6, Types.NUMERIC);
            stmt.registerOutParameter(7, Types.NUMERIC);
            stmt.registerOutParameter(8, Types.NUMERIC);
            stmt.registerOutParameter(9, Types.NUMERIC);
            stmt.registerOutParameter(10, Types.NUMERIC);
            stmt.registerOutParameter(11, Types.NUMERIC);
            // Exécution de la procédure
            stmt.execute();

            // Récupération des résultats
            montantAECPDto.setMontantN1(stmt.getBigDecimal(6));
            montantAECPDto.setMontantN2(stmt.getBigDecimal(7));
            montantAECPDto.setMontantN3(stmt.getBigDecimal(8));
            montantAECPDto.setMontantN1AE(stmt.getBigDecimal(9));
            montantAECPDto.setMontantN2AE(stmt.getBigDecimal(10));
            montantAECPDto.setMontantN3AE(stmt.getBigDecimal(11));

        } catch (Exception e) {
            logger.error("Une erreur s'est produite dans la partie récupération montants AE/CP", e);
            /*responseDto.setEtat(0);
            responseDto.setMessageErreur("Une erreur s'est produite dans la partie récupération montants AE/CP");
            return responseDto;*/
        }finally {
            // Fermer le CallableStatement et la connexion
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                logger.error("Une erreur s'est produite dans la partie récupération montants AE/CP lors de la fermeture des ressources", e);
            }
        }
        return montantAECPDto;
    }
}