package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.TraitementUsageDto;
import ma.servicessanitaires.exceptions.TraitementUsageNotFoundException;
import ma.servicessanitaires.services.TraitementUsageService.TraitementUsageSer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class TraitementUsageApi {
    private TraitementUsageSer traitementUsageSer;
    @GetMapping("/traitementUsages")
    public List<TraitementUsageDto> traitementUsages(){
        return traitementUsageSer.listTraitementUsages();
    }
    @GetMapping("/traitementUsages/{traitementUsageId}")
    public TraitementUsageDto getTraitementUsage(@PathVariable Long traitementUsageId) throws TraitementUsageNotFoundException {
        return traitementUsageSer.getTraitementUsage(traitementUsageId);
    }
    @PostMapping("/traitementUsages")
    public TraitementUsageDto saveTraitementUsage(@RequestBody TraitementUsageDto traitementUsageDto){
        return traitementUsageSer.createTraitementUsage(traitementUsageDto);
    }
    @PutMapping("/traitementUsages/{traitementUsageId}")
    public TraitementUsageDto updateTraitementUsages(@PathVariable Long traitementUsageId, @RequestBody TraitementUsageDto traitementUsageDto){
        traitementUsageDto.setId(traitementUsageId);
        return traitementUsageSer.updateTraitementUsage(traitementUsageDto);
    }
    @DeleteMapping("/traitementUsages/{id}")
    public void deleteTraitementUsage(@PathVariable Long id){
        traitementUsageSer.deleteTraitementUsage(id);
    }
}
