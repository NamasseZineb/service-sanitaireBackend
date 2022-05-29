package ma.servicessanitaires.services.SpecialiteService;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedecinDto;
import ma.servicessanitaires.dtos.SpecialiteDto;
import ma.servicessanitaires.dtos.SpecialiteDto;
import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.entities.RendezVous;
import ma.servicessanitaires.entities.Specialite;
import ma.servicessanitaires.enums.RendezVousStatus;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.RendezvousNotFoundException;
import ma.servicessanitaires.exceptions.SpecialiteNotFoundException;
import ma.servicessanitaires.mappers.SpecialiteMapper;
import ma.servicessanitaires.repositories.PatientRepo;
import ma.servicessanitaires.repositories.RendezVousRepo;
import ma.servicessanitaires.repositories.SpecialiteRepo;
import ma.servicessanitaires.services.rendezVousService.RendezVousSer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class SpecialiteSerImpl implements SpecialiteSer {
    private SpecialiteRepo specialiteRepo;
    private SpecialiteMapper specialiteMapper;

    @Override
    public SpecialiteDto createSpecialite(SpecialiteDto specialiteDto) {
        Specialite specialite=specialiteMapper.fromSpecialiteDto(specialiteDto);
        return specialiteMapper.fromSpecialite(specialite);
    }

    @Override
    public SpecialiteDto updateSpecialite(SpecialiteDto specialiteDto) {
        Specialite specialite=specialiteMapper.fromSpecialiteDto(specialiteDto);
        return specialiteMapper.fromSpecialite(specialiteRepo.save(specialite));
    }

    @Override
    public List<SpecialiteDto> listSpecialites() {
        List<Specialite> specialites = specialiteRepo.findAll();
        List<SpecialiteDto> specialiteDtos = specialites.stream()
                .map(specialite -> specialiteMapper.fromSpecialite(specialite))
                .collect(Collectors.toList());
        return specialiteDtos;
    }

    @Override
    public SpecialiteDto getSpecialite(Long id) throws SpecialiteNotFoundException {
        Specialite specialite = specialiteRepo.findById(id)
                .orElseThrow(() -> new SpecialiteNotFoundException("Medecin inexistant"));
        return specialiteMapper.fromSpecialite(specialite) ;
    }

    @Override
    public void deleteSpecialite(Long id) {
        specialiteRepo.deleteById(id);
    }
}
