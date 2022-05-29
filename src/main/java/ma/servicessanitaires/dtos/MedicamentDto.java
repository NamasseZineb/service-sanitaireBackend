package ma.servicessanitaires.dtos;

import lombok.Data;
import ma.servicessanitaires.entities.TraitementUsage;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Data
public class MedicamentDto {
    private Long id;
    private String nomCommercial;
    private Double prix;
    private Double mesure;
    private String uniteDeMesure;
    private String description;
    private String urlImg;
    private String forme;
    private String effetsSecondaires;
    private List<TraitementUsage> traitementUsages;
}
