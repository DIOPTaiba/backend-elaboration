package sn.sysbudgep.elaboration.service.global;

import sn.sysbudgep.elaboration.dto.global.SourceFinDto;

import java.util.List;

public interface SourceFinService {
    List<SourceFinDto> getSourceFinByTypeFin(String tfinId);
}