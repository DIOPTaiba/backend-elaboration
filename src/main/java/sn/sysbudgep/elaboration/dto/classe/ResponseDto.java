package sn.sysbudgep.elaboration.dto.classe;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String numero;
    private int etat;
    private String messageErreur;
}

