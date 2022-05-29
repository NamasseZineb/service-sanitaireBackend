package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedicamentDto;
import ma.servicessanitaires.exceptions.MedicamentNotFoundException;
import ma.servicessanitaires.services.MedicamentService.MedicamentSer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class MedicamentApi {
    private MedicamentSer medicamentSer;
    @GetMapping("/medicaments")
    public List<MedicamentDto> Medicaments(){
        return medicamentSer.listMedicaments();
    }
    @GetMapping("/medicaments/{medicamentId}")
    public MedicamentDto getMedicament(@PathVariable Long medicamentId) throws MedicamentNotFoundException {
        return medicamentSer.getMedicament(medicamentId);
    }
    @PostMapping("/medicaments")
    public MedicamentDto saveMedicament(@RequestBody MedicamentDto medicamentDto){
        return medicamentSer.createMedicament(medicamentDto);
    }
    @PutMapping("/medicaments/{medicamentId}")
    public MedicamentDto updateMedicaments(@PathVariable Long medicamentId, @RequestBody MedicamentDto medicamentDto){
        medicamentDto.setId(medicamentId);
        return medicamentSer.updateMedicament(medicamentDto);
    }
    @DeleteMapping("/medicaments/{id}")
    public void deleteMedicament(@PathVariable Long id){
        medicamentSer.deleteMedicament(id);
    }
}
