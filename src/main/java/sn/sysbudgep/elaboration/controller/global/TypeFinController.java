package sn.sysbudgep.elaboration.controller.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.global.TypeFinDto;
import sn.sysbudgep.elaboration.service.global.TypeFinService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class TypeFinController {

    private final TypeFinService typeFinService;
    public TypeFinController(TypeFinService typeFinService) {
        this.typeFinService = typeFinService;
    }

    @GetMapping("/typesFin")
    public ResponseEntity<List<TypeFinDto>> getAllTypeFin() {
        return ResponseEntity.ok(typeFinService.getAllTypeFin());
    }
}