package sn.sysbudgep.elaboration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDeBudgetDto {
    private String expbCode;
    private String expbLib;
    private Timestamp expbDebut;
}
