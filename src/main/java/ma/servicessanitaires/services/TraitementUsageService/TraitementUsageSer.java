package ma.servicessanitaires.services.TraitementUsageService;

import ma.servicessanitaires.dtos.TraitementUsageDto;
import ma.servicessanitaires.exceptions.TraitementUsageNotFoundException;

import java.util.List;

public interface TraitementUsageSer {
    TraitementUsageDto createTraitementUsage(TraitementUsageDto TraitementUsageDto);
    TraitementUsageDto updateTraitementUsage(TraitementUsageDto TraitementUsageDto);
    List<TraitementUsageDto> listTraitementUsages();
    TraitementUsageDto getTraitementUsage(Long id) throws TraitementUsageNotFoundException;
    void deleteTraitementUsage(Long id);
}
