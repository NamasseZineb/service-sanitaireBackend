package ma.servicessanitaires.mappers;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedicamentDto;
import ma.servicessanitaires.entities.Medicament;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicamentMapper {
    public MedicamentDto fromMedicament(Medicament medicament){
        MedicamentDto medicamentDto=new MedicamentDto();
        BeanUtils.copyProperties(medicament,medicamentDto);
        return medicamentDto;
    }
    public Medicament fromMedicamentDto(MedicamentDto medicamentDto){
        Medicament medicament=new Medicament();
        BeanUtils.copyProperties(medicamentDto,medicament);
        return medicament;
    }
}
