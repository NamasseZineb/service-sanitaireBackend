package ma.servicessanitaires.mappers;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedecinDto;
import ma.servicessanitaires.dtos.SpecialiteDto;
import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.entities.Specialite;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecialiteMapper {


    public SpecialiteDto fromSpecialite(Specialite specialite){
        SpecialiteDto specialiteDto=new SpecialiteDto();
        BeanUtils.copyProperties(specialite,specialiteDto);
        return specialiteDto;
    }
    public Specialite fromSpecialiteDto(SpecialiteDto specialiteDto){
        Specialite specialite=new Specialite();
        BeanUtils.copyProperties(specialiteDto,specialite);
        return specialite;
    }
}
