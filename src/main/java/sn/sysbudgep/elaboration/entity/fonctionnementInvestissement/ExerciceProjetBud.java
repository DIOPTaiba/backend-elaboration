package sn.sysbudgep.elaboration.entity.fonctionnementInvestissement;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.sql.Timestamp;

@Data
@Entity
@Immutable
@Table(name = "vb3_exercice_projet_bud")
public class ExerciceProjetBud {

    @Id
    @Column(name = "EXPB_CODE")
    private String expbCode;

    @Column(name = "EXPB_LIB")
    private String expbLib;

    @Column(name = "EXPB_DEBUT")
    private Timestamp expbDebut;
}
