package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

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
import sn.sysbudgep.elaboration.dto.classe.ResponseDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.ChapitreEffectifsDto;
import sn.sysbudgep.elaboration.dto.global.LigneBudgetDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.ChapitreEffectifsRepository;
import sn.sysbudgep.elaboration.repository.fonctionnementInvestissement.SaisieMajFctInvesRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MajEmploisEffectifsService;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public List<ChapitreEffectifsDto> chapitreEffectifs(ParametreRechercheDTO pr) throws SQLException, ParseException {
        return chapitreEffectifsRepository.chapitreEffectifs(pr.getExeCode(), pr.getExeCode1(), pr.getProId());
    }
}