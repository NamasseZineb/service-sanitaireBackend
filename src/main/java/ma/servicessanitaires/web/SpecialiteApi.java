package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.SpecialiteDto;
import ma.servicessanitaires.exceptions.SpecialiteNotFoundException;
import ma.servicessanitaires.services.SpecialiteService.SpecialiteSer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class SpecialiteApi {
    private SpecialiteSer specialiteSer;
    @GetMapping("/specialites")
    public List<SpecialiteDto> specialites(){
        return specialiteSer.listSpecialites();
    }
    @GetMapping("/specialites/{specialiteId}")
    public SpecialiteDto getSpecialite(@PathVariable Long specialiteId) throws SpecialiteNotFoundException {
        return specialiteSer.getSpecialite(specialiteId);
    }
    @PostMapping("/specialites")
    public SpecialiteDto saveSpecialite(@RequestBody SpecialiteDto specialiteDto){
        return specialiteSer.createSpecialite(specialiteDto);
    }
    @PutMapping("/specialites/{specialiteId}")
    public SpecialiteDto updateSpecialites(@PathVariable Long specialiteId, @RequestBody SpecialiteDto specialiteDto){
        specialiteDto.setId(specialiteId);
        return specialiteSer.updateSpecialite(specialiteDto);
    }
    @DeleteMapping("/specialites/{id}")
    public void deleteSpecialite(@PathVariable Long id){
        specialiteSer.deleteSpecialite(id);
    }
}
