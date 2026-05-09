package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.SourceFinDto;
import sn.sysbudgep.elaboration.repository.global.SourceFinRepository;
import sn.sysbudgep.elaboration.service.global.SourceFinService;

import java.util.List;

@Service
public class SourceFinServiceImpl implements SourceFinService {

    private final SourceFinRepository sourceFinRepository;

    public SourceFinServiceImpl(SourceFinRepository sourceFinRepository) {
        this.sourceFinRepository = sourceFinRepository;
    }

    @Override
    public List<SourceFinDto> getSourceFinByTypeFin(String tfinId) {
        return sourceFinRepository.findSourceFinByTypeFin(tfinId);
    }
}