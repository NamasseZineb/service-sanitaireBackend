package ma.servicessanitaires.dtos;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import ma.servicessanitaires.entities.Image;
import java.util.Date;

@Data
public class PatientDto {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private String sexe;
    private String adresse;
    private String email;
    private String pwd;
    private String tel;
    @Enumerated(EnumType.STRING)
    private String situationFamiliale;
    private Long imageId;
    private String nom_a_prvenir;
    private String tel_a_prevenir;
}
