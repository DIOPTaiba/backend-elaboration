package sn.sysbudgep.elaboration.dto.classe;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParametreRechercheDTO {
    private int exe;
    private String exeCode="";
    private String sectionId="";
    private String sectionCode="";
    private String proId="";
    private String proCode="";
    private String chapId="";
    private String chapCode="";
    private String typeFinCode="";
    private String sfinCode="";
    private String cadeCode="";
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dateDebut="";
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dateFin="";
}
