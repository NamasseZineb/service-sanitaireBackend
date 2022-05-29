package ma.servicessanitaires.services.MedicamentService;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedicamentDto;
import ma.servicessanitaires.entities.Medicament;
import ma.servicessanitaires.exceptions.MedicamentNotFoundException;
import ma.servicessanitaires.mappers.MedicamentMapper;
import ma.servicessanitaires.repositories.MedicamentRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class MedicamentSerImpl implements MedicamentSer {
    private MedicamentRepo medicamentRepo;
    private MedicamentMapper medicamentMapper;
    @Override
    public MedicamentDto createMedicament(MedicamentDto medicamentDto) {
        Medicament medicament=medicamentMapper.fromMedicamentDto(medicamentDto);
        return medicamentMapper.fromMedicament(medicament);
    }

    @Override
    public MedicamentDto updateMedicament(MedicamentDto medicamentDto) {
        Medicament medicament=medicamentMapper.fromMedicamentDto(medicamentDto);
        return medicamentMapper.fromMedicament(medicamentRepo.save(medicament));
    }

    @Override
    public List<MedicamentDto> listMedicaments() {
        List<Medicament> medicaments = medicamentRepo.findAll();
        List<MedicamentDto> medicamentDtos = medicaments.stream()
                .map(medicament -> medicamentMapper.fromMedicament(medicament))
                .collect(Collectors.toList());
        return medicamentDtos;
    }

    @Override
    public MedicamentDto getMedicament(Long id) throws MedicamentNotFoundException {
        Medicament medicament = medicamentRepo.findById(id)
                .orElseThrow(() -> new MedicamentNotFoundException("Medecin inexistant"));
        return medicamentMapper.fromMedicament(medicament) ;
    }

    @Override
    public void deleteMedicament(Long id) {
        medicamentRepo.deleteById(id);
    }
}
