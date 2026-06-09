package sn.sysbudgep.elaboration.dto.classe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraitementsAgentDto {
    private String exeCode="";
    private String matricule="";
    private String natId="";
    private Integer traitementId;
    private BigDecimal montant;
    private String foncatId="";
    private String foncatIdModif="";
    private String textReference="";
    private String observations="";
}