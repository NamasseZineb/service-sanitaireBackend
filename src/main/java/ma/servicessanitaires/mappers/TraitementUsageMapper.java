package ma.servicessanitaires.mappers;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.TraitementUsageDto;
import ma.servicessanitaires.entities.TraitementUsage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TraitementUsageMapper {
    public TraitementUsageDto fromTraitementUsage(TraitementUsage traitementUsage){
        TraitementUsageDto traitementUsageDto=new TraitementUsageDto();
        BeanUtils.copyProperties(traitementUsage,traitementUsageDto);
        return traitementUsageDto;
    }
    public TraitementUsage fromTraitementUsageDto(TraitementUsageDto traitementUsageDto){
        TraitementUsage traitementUsage=new TraitementUsage();
        BeanUtils.copyProperties(traitementUsageDto,traitementUsage);
        return traitementUsage;
    }
}
