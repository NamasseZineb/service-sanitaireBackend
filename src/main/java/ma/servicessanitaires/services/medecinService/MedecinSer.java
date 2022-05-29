package ma.servicessanitaires.services.medecinService;

import ma.servicessanitaires.dtos.MedecinDto;
import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;

import java.util.List;

public interface MedecinSer {
    MedecinDto createMedecin(MedecinDto MedecinDto);
    MedecinDto updateMedecin(MedecinDto MedecinDto);
    List<MedecinDto> listMedecins();
    MedecinDto getMedecin(Long id) throws MedecinNotFoundException;
    Medecin Connect(String email, String pwd);
    void deleteMedecin(Long id);
}
