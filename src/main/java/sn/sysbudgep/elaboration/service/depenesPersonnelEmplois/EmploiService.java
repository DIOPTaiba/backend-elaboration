package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;

import java.util.List;

public interface EmploiService {
        List<EmploiDto> getAllEmplois();
}
