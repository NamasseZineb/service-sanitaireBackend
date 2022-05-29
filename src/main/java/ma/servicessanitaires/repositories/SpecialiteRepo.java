package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepo extends JpaRepository<Specialite,Long> {
    Specialite findBySpecialite(String specialite);
}
