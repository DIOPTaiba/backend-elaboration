package sn.sysbudgep.elaboration.entity.fonctionnementInvestissement;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "vb3_programme")
public class Programme {

    @Id
    @Column(name = "PRO_ID")
    private Integer proId;

    @Column(name = "PRO_CODE")
    private String proCode;

    @Column(name = "PRO_LIBELLE")
    private String proLibelle;

    @Column(name = "PRO_SEC_ID")
    private Integer proSecId;


}