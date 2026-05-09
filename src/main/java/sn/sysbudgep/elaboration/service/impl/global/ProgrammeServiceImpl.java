package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.ProgrammeDto;
import sn.sysbudgep.elaboration.repository.global.ProgrammeRepository;
import sn.sysbudgep.elaboration.service.global.ProgrammeService;

import java.util.List;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {

    private final ProgrammeRepository programmeRepository;

    public ProgrammeServiceImpl(ProgrammeRepository programmeRepository) {
        this.programmeRepository = programmeRepository;
    }

    @Override
    public List<ProgrammeDto> getProgrammes(String secId, String exercice) {
        return programmeRepository.findProgrammes(secId, exercice);
    }
}