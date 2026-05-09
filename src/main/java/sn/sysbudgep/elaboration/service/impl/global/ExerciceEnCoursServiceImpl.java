package sn.sysbudgep.elaboration.service.impl.global;

import org.springframework.stereotype.Service;
import sn.sysbudgep.elaboration.repository.global.ExerciceEnCoursRepository;
import sn.sysbudgep.elaboration.service.global.ExerciceEnCoursService;

@Service
public class ExerciceEnCoursServiceImpl implements ExerciceEnCoursService {

    private final ExerciceEnCoursRepository exerciceEnCoursRepository;

    public ExerciceEnCoursServiceImpl(ExerciceEnCoursRepository exerciceEnCoursRepository) {
        this.exerciceEnCoursRepository = exerciceEnCoursRepository;
    }

    @Override
    public String getExerciceEnCours() {
        return exerciceEnCoursRepository.getExerciceEnCours();
    }
}