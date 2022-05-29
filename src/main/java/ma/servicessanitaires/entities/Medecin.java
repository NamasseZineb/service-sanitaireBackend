package ma.servicessanitaires.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("MD")
public class Medecin extends Personne{
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Specialite specialite;
}
