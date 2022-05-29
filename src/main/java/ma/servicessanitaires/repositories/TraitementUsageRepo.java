package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.TraitementUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraitementUsageRepo extends JpaRepository<TraitementUsage,Long> {
    TraitementUsage findByDosage(String dosage);
}
