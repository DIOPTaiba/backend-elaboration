package sn.sysbudgep.elaboration.controller.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.global.ProgrammeDto;
import sn.sysbudgep.elaboration.service.global.ProgrammeService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProgrammeController {

    private final ProgrammeService programmeService;

    public ProgrammeController(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }

    @GetMapping("/programmes/{secId}/{exercice}")
    public ResponseEntity<List<ProgrammeDto>> getProgrammes(
            @PathVariable String secId,
            @PathVariable String exercice) {
        return ResponseEntity.ok(programmeService.getProgrammes(secId, exercice));
    }
}