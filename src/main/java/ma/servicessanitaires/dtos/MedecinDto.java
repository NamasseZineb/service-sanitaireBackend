package ma.servicessanitaires.dtos;

import lombok.Data;
import ma.servicessanitaires.entities.Specialite;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data
public class MedecinDto {
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
    private Specialite specialite;
}
