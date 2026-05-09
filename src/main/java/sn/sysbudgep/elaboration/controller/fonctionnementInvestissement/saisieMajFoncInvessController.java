package sn.sysbudgep.elaboration.controller.fonctionnementInvestissement;

import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.service.fonctionnementInvestissement.SaisieMajFctInvesService;

@RestController
@RequestMapping("/saisieMaj")
public class saisieMajFoncInvessController {

    private final SaisieMajFctInvesService saisieMajFctInvesService;

    public saisieMajFoncInvessController(SaisieMajFctInvesService saisieMajFctInvesService) {
        this.saisieMajFctInvesService = saisieMajFctInvesService;
    }
}