package sn.sysbudgep.elaboration.entity.fonctionnementInvestissement;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "vb3_type_fin")
public class TypeFin {

    @Id
    @Column(name = "TFIN_ID")
    private Integer tfinId;

    @Column(name = "TFIN_CODE")
    private String tfinCode;

    @Column(name = "TFIN_LIB")
    private String tfinLib;

    @Column(name = "TFIN_VALID")
    private String tfinValid;

    @Column(name = "TFIN_TYPRB_ID")
    private Integer tfinTyprbId;
}