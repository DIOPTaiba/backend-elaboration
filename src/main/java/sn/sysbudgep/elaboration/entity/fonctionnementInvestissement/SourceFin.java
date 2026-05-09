package sn.sysbudgep.elaboration.entity.fonctionnementInvestissement;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "vb3_source_fin")
public class SourceFin {

    @Id
    @Column(name = "SFIN_CODE")
    private String sfinCode;

    @Column(name = "SFIN_LIB")
    private String sfinLib;

    @Column(name = "SFIN_FONCACT_ID")
    private Integer sfinFoncactId;

    @Column(name = "SFIN_VALID")
    private String sfinValid;

    @Column(name = "SFIN_CODE_NBE")
    private Integer sfinCodeNbe;

    @Column(name = "SFIN_TYPRB_ID")
    private Integer sfinTyprbId;

    @Column(name = "SFIN_BAILF_CODE")
    private String sfinBailfCode;

    @Column(name = "SFIN_TFIN_ID")
    private Integer sfinTfinId;
}