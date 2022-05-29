package ma.servicessanitaires.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class SpecialiteDto {
    private Long id;
    private String specialite;
}
