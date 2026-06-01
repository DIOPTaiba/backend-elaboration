package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MesureNouvelleDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.MesureNouvelleRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.MesureNouvelleService;

import java.util.List;

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
}