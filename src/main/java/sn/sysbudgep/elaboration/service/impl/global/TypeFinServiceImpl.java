package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.dto.global.TypeFinDto;
import sn.sysbudgep.elaboration.repository.global.TypeFinRepository;
import sn.sysbudgep.elaboration.service.global.TypeFinService;

import java.util.List;

@Service
public class TypeFinServiceImpl implements TypeFinService {

    private final TypeFinRepository typeFinRepository;

    public TypeFinServiceImpl(TypeFinRepository typeFinRepository) {
        this.typeFinRepository = typeFinRepository;
    }

    @Override
    public List<TypeFinDto> getAllTypeFin() {
        return typeFinRepository.findAllTypeFin();
    }
}