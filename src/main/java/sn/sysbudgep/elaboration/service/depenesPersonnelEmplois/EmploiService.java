package sn.sysbudgep.elaboration.service.depenesPersonnelEmplois;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.EmploiDto;
import sn.sysbudgep.elaboration.dto.depensesPersonnelEmplois.MajEmploisEffectifsDto;

import java.util.List;

public interface EmploiService {
        List<EmploiDto> getAllEmplois();

        List<MajEmploisEffectifsDto> emploisEffectifs(ParametreRechercheDTO pr);
}
