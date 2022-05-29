package ma.servicessanitaires.services.MedicamentService;

import ma.servicessanitaires.dtos.MedicamentDto;
import ma.servicessanitaires.exceptions.MedicamentNotFoundException;

import java.util.List;

public interface MedicamentSer {
    MedicamentDto createMedicament(MedicamentDto MedicamentDto);
    MedicamentDto updateMedicament(MedicamentDto MedicamentDto);
    List<MedicamentDto> listMedicaments();
    MedicamentDto getMedicament(Long id) throws MedicamentNotFoundException;
    void deleteMedicament(Long id);
}
