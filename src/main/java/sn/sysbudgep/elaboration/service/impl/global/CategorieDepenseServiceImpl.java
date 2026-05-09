package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.CategorieDepenseDto;
import sn.sysbudgep.elaboration.repository.global.CategorieDepenseRepository;
import sn.sysbudgep.elaboration.service.global.CategorieDepenseService;

import java.util.List;

@Service
public class CategorieDepenseServiceImpl implements CategorieDepenseService {

    private final CategorieDepenseRepository categorieDepenseRepository;

    public CategorieDepenseServiceImpl(CategorieDepenseRepository categorieDepenseRepository) {
        this.categorieDepenseRepository = categorieDepenseRepository;
    }

    @Override
    public List<CategorieDepenseDto> getCategoriesDepense(String proCode) {
        return categorieDepenseRepository.findCategoriesDepense(proCode);
    }
}