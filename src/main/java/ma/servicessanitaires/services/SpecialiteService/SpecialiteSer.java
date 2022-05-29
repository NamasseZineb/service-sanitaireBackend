package ma.servicessanitaires.services.SpecialiteService;

import ma.servicessanitaires.dtos.SpecialiteDto;
import ma.servicessanitaires.entities.Specialite;
import ma.servicessanitaires.exceptions.SpecialiteNotFoundException;

import java.util.List;

public interface SpecialiteSer {
    SpecialiteDto createSpecialite(SpecialiteDto SpecialiteDto);
    SpecialiteDto updateSpecialite(SpecialiteDto SpecialiteDto);
    List<SpecialiteDto> listSpecialites();
    SpecialiteDto getSpecialite(Long id) throws SpecialiteNotFoundException;
    void deleteSpecialite(Long id);
}
