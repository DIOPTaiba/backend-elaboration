package sn.sysbudgep.elaboration.service.impl.depenesPersonnelEmplois;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.repository.DepensesPersonnelEmplois.EmploiRepository;
import sn.sysbudgep.elaboration.service.depenesPersonnelEmplois.EmploiService;

import java.util.List;

@Service
public class EmploiServiceimpl implements EmploiService {
    private final EmploiRepository emploiRepository ;

    public EmploiServiceimpl(EmploiRepository emploiRepository ) {
        this.emploiRepository = emploiRepository;
    }
    @Override
    public List<EmploiDto> getAllEmplois() {
            return emploiRepository.findAllEmplois();
    }
}
