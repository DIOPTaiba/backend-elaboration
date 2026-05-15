package sn.sysbudgep.elaboration.dto.classe;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ParametreRechercheDTO {
    private int exe;
    private String exeCode="";

    public int getExe() {
        return exe;
    }

    public void setExe(int exe) {
        this.exe = exe;
    }

    public String getExeCode() {
        return exeCode;
    }

    public void setExeCode(String exeCode) {
        this.exeCode = exeCode;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getChapId() {
        return chapId;
    }

    public void setChapId(String chapId) {
        this.chapId = chapId;
    }

    public String getChapCode() {
        return chapCode;
    }

    public void setChapCode(String chapCode) {
        this.chapCode = chapCode;
    }

    public String getTypeFinCode() {
        return typeFinCode;
    }

    public void setTypeFinCode(String typeFinCode) {
        this.typeFinCode = typeFinCode;
    }

    public String getSfinCode() {
        return sfinCode;
    }

    public void setSfinCode(String sfinCode) {
        this.sfinCode = sfinCode;
    }

    public String getCadeCode() {
        return cadeCode;
    }

    public void setCadeCode(String cadeCode) {
        this.cadeCode = cadeCode;
    }

    public String getBudcCode() {
        return budcCode;
    }

    public void setBudcCode(String budcCode) {
        this.budcCode = budcCode;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    private String sectionId="";
    private String sectionCode="";
    private String proId="";
    private String proCode="";
    private String chapId="";
    private String chapCode="";
    private String typeFinCode="";
    private String sfinCode="";
    private String cadeCode="";
    private String budcCode="";
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dateDebut="";
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dateFin="";
}
