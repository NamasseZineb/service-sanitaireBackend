package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedecinDto;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.services.medecinService.MedecinSer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class MedecinApi {
    private MedecinSer medecinSer;
    @GetMapping("/medecins")
    public List<MedecinDto> medecins(){
        return medecinSer.listMedecins();
    }
    @GetMapping("/medecins/{medecinId}")
    public MedecinDto getMedecin(@PathVariable Long medecinId) throws MedecinNotFoundException {
        return medecinSer.getMedecin(medecinId);
    }
    @PostMapping("/medecins")
    public MedecinDto saveMedecin(@RequestBody MedecinDto medecinDto){
        return medecinSer.createMedecin(medecinDto);
    }
    @PutMapping("/medecins/{medecinId}")
    public MedecinDto updateMedecins(@PathVariable Long medecinId, @RequestBody MedecinDto medecinDto){
        medecinDto.setId(medecinId);
        return medecinSer.updateMedecin(medecinDto);
    }
    @DeleteMapping("/medecins/{id}")
    public void deleteMedecin(@PathVariable Long id){
        medecinSer.deleteMedecin(id);
    }
}
