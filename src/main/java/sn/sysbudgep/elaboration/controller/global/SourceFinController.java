package sn.sysbudgep.elaboration.controller.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.global.SourceFinDto;
import sn.sysbudgep.elaboration.service.global.SourceFinService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class SourceFinController {

    private final SourceFinService sourceFinService;

    public SourceFinController(SourceFinService sourceFinService) {
        this.sourceFinService = sourceFinService;
    }

    @GetMapping("/sourcesFin/{tfinId}")
    public ResponseEntity<List<SourceFinDto>> getSourceFinByTypeFin(@PathVariable String tfinId) {
        return ResponseEntity.ok(sourceFinService.getSourceFinByTypeFin(tfinId));
    }
}