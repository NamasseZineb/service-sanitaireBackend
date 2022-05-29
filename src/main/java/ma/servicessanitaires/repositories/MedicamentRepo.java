package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepo extends JpaRepository<Medicament,Long> {
    Medicament findByNomCommercial(String nomCommercial);
}
