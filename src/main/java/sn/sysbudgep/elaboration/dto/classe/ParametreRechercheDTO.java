package sn.sysbudgep.elaboration.dto.classe;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Types;


@Getter
@Setter
public class ParametreRechercheDTO {
    private int exe;
    private String exeCode0="";
    private String exeCode="";
    private String sectionId="";
    private String sectionCode="";
    private String proId="";
    private String proCode="";
    private String chapId="";
    private String chapCode="";
    private String typeFinCode="";
    private String sfinCode="";
    private String sfinCodeNew="";
    private String cadeCode="";
    private String budcCode="";
    private String natId="";
    private Integer natIdNumber;
    private String natCode="";
    private String matricule="";
    private String nom="";
    private String prenom="";
    private String codeEmploi="";
    private Integer idEmploi;
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dateDebut="";
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dateFin="";
    private int bailfCode;
    private BigDecimal cp1Prec;
    private BigDecimal cp1;
    private BigDecimal aeAnt;
    private BigDecimal ae1Prec;
    private BigDecimal ae1;
    private BigDecimal cpMn;
    private BigDecimal aeMn;
    private String foncatId="";
    private String foncatIdModif="";
    private String observations="";
    private int effectif;

}
