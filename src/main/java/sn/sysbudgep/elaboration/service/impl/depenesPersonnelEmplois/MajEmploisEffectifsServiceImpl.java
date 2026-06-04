package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MajEmploisEffectifsDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.ChapitreEffectifsRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MajEmploisEffectifsService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

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

}