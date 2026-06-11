package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.SectionDto;
import sn.sysbudgep.elaboration.dto.global.TypeFinDto;
import sn.sysbudgep.elaboration.repository.global.SectionRepository;
import sn.sysbudgep.elaboration.repository.global.TypeFinRepository;
import sn.sysbudgep.elaboration.service.global.SectionService;
import sn.sysbudgep.elaboration.service.global.TypeFinService;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public List<SectionDto> listeSection() {
        return sectionRepository.listeSection();
    }
}