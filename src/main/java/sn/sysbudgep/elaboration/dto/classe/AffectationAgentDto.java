package sn.sysbudgep.elaboration.dto.classe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffectationAgentDto {
    private String exeCode="";
    private Integer idTraitement;
    private String matricule="";
    private String chapId="";
    private String chapIdPrecedant="";
    private String sectionId="";
    private String sectionIdPrecedant="";
    private String textReference="";
    private String observations="";
    private String foncatIdModif="";
}