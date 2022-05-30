package ma.servicessanitaires.mappers;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedicamentDto;
import ma.servicessanitaires.entities.Medicament;
import ma.servicessanitaires.repositories.MedicamentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ma.servicessanitaires.repositories.ImageRepo;
import ma.servicessanitaires.entities.*;

@Service
@AllArgsConstructor
public class MedicamentMapper {
    private ImageRepo imageRepo;
    public MedicamentDto fromMedicament(Medicament medicament){
        MedicamentDto medicamentDto=new MedicamentDto();
        BeanUtils.copyProperties(medicament,medicamentDto);
        return medicamentDto;
    }
    public Medicament fromMedicamentDto(MedicamentDto medicamentDto){
        Medicament medicament=new Medicament();
        Image image = imageRepo.findById(medicamentDto.getImageId()).orElse(null);
        BeanUtils.copyProperties(medicamentDto,medicament);
        medicament.setImage(image);
        return medicament;
    }
}
