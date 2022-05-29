package ma.servicessanitaires.services.TraitementUsageService;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.TraitementUsageDto;
import ma.servicessanitaires.entities.TraitementUsage;
import ma.servicessanitaires.exceptions.TraitementUsageNotFoundException;
import ma.servicessanitaires.mappers.TraitementUsageMapper;
import ma.servicessanitaires.repositories.TraitementUsageRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class TraitementUsageImpl implements TraitementUsageSer{
    private TraitementUsageRepo traitementUsageRepo;
    private TraitementUsageMapper traitementUsageMapper;
    @Override
    public TraitementUsageDto createTraitementUsage(TraitementUsageDto traitementUsageDto) {
        TraitementUsage traitementUsage=traitementUsageMapper.fromTraitementUsageDto(traitementUsageDto);
        return traitementUsageMapper.fromTraitementUsage(traitementUsage);
    }

    @Override
    public TraitementUsageDto updateTraitementUsage(TraitementUsageDto traitementUsageDto) {
        TraitementUsage traitementUsage=traitementUsageMapper.fromTraitementUsageDto(traitementUsageDto);
        return traitementUsageMapper.fromTraitementUsage(traitementUsageRepo.save(traitementUsage));
    }

    @Override
    public List<TraitementUsageDto> listTraitementUsages() {
        List<TraitementUsage> traitementUsages = traitementUsageRepo.findAll();
        List<TraitementUsageDto> traitementUsageDtos = traitementUsages.stream()
                .map(traitementUsage -> traitementUsageMapper.fromTraitementUsage(traitementUsage))
                .collect(Collectors.toList());
        return traitementUsageDtos;
    }

    @Override
    public TraitementUsageDto getTraitementUsage(Long id) throws TraitementUsageNotFoundException {
        TraitementUsage traitementUsage = traitementUsageRepo.findById(id)
                .orElseThrow(() -> new TraitementUsageNotFoundException("Medecin inexistant"));
        return traitementUsageMapper.fromTraitementUsage(traitementUsage) ;
    }

    @Override
    public void deleteTraitementUsage(Long id) {
        traitementUsageRepo.deleteById(id);
    }
}
