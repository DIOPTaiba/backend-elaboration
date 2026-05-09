package sn.sysbudgep.elaboration.entity.fonctionnementInvestissement;


import jakarta.persistence.*;

@Entity
@Table(name = "vb3_exercice_projet_bud") // ← nom d'une de tes tables existantes
public class SaisieMajFctInves {

    @Id
    @Column(name = "EXPB_CODE")
    private String id;

    // ← pas besoin d'autres colonnes

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
