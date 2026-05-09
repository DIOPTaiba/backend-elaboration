package sn.sysbudgep.elaboration.controller.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.dto.global.CategorieDepenseDto;
import sn.sysbudgep.elaboration.service.global.CategorieDepenseService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class CategorieDepenseController {

    private final CategorieDepenseService categorieDepenseService;

    public CategorieDepenseController(CategorieDepenseService categorieDepenseService) {
        this.categorieDepenseService = categorieDepenseService;
    }

    @GetMapping("/categoriesDepense/{proCode}")
    public ResponseEntity<List<CategorieDepenseDto>> getCategoriesDepense(@PathVariable String proCode) {
        return ResponseEntity.ok(categorieDepenseService.getCategoriesDepense(proCode));
    }
}