package sn.sysbudgep.elaboration.service.global;

import sn.sysbudgep.elaboration.dto.global.ProgrammeDto;

import java.util.List;

public interface ProgrammeService {
    List<ProgrammeDto> getProgrammes(String secId, String exercice);
}