package sn.sysbudgep.elaboration.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sections")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class sectionController {

    // liste sections
    @GetMapping(value = "/test")
    public String getAllSections () {
        System.out.println("getAllSections");
        return "Test";
    }
}
