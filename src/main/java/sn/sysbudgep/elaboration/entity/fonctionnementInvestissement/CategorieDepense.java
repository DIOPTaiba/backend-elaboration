package sn.sysbudgep.elaboration.entity.fonctionnementInvestissement;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "vb3_categorie_depense")
public class CategorieDepense {

    @Id
    @Column(name = "CADE_CODE")
    private String cadeCode;

    @Column(name = "CADE_LIB")
    private String cadeLib;
}