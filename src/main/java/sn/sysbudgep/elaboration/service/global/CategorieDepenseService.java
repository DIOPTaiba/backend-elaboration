package sn.sysbudgep.elaboration.service.global;

import sn.sysbudgep.elaboration.dto.global.CategorieDepenseDto;

import java.util.List;

public interface CategorieDepenseService {
    List<CategorieDepenseDto> getCategoriesDepense(String proCode);
}