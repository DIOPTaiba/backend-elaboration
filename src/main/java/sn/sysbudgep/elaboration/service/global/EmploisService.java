package sn.sysbudgep.elaboration.service.global;

import sn.sysbudgep.elaboration.dto.classe.ParametreRechercheDTO;
import sn.sysbudgep.elaboration.dto.global.Agents;
import sn.sysbudgep.elaboration.dto.global.Emplois;

import java.util.List;

public interface EmploisService {
    List<Emplois> emplois();
}