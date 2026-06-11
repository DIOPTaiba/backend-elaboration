package sn.sysbudgep.elaboration.controller.global;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.global.SectionDto;
import sn.sysbudgep.elaboration.service.global.SectionService;

import java.util.List;

@RestController
@RequestMapping("/sections")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    // liste sections
    @GetMapping(value = "")
    public List<SectionDto> listeSection () {
        return sectionService.listeSection();
    }
}
