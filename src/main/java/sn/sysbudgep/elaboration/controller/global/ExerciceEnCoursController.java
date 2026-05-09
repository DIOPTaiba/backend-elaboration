package sn.sysbudgep.elaboration.controller.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sysbudgep.elaboration.service.global.ExerciceEnCoursService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin(origins = "*",maxAge = 3600)
public class ExerciceEnCoursController {

    private final ExerciceEnCoursService exerciceEnCoursService;

    public ExerciceEnCoursController(ExerciceEnCoursService exerciceEnCoursService) {
        this.exerciceEnCoursService = exerciceEnCoursService;
    }

    @GetMapping("/exerciceEnCours")
    public ResponseEntity<String> getExerciceEnCours() {
        return ResponseEntity.ok(exerciceEnCoursService.getExerciceEnCours());
    }
}