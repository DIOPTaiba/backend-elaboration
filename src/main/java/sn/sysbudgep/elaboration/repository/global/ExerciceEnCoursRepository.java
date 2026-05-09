package sn.sysbudgep.elaboration.repository.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.entity.fonctionnementInvestissement.SaisieMajFctInves;

@Repository
public interface ExerciceEnCoursRepository extends JpaRepository<SaisieMajFctInves, String> {

    @Query(value = "SELECT fb3_par_val('EXERCICE') FROM dual", nativeQuery = true)
    String getExerciceEnCours();
}