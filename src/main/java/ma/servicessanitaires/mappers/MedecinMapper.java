package ma.servicessanitaires.mappers;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedecinDto;
import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.repositories.MedecinRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedecinMapper {


    public MedecinDto fromMedecin(Medecin medecin){
        MedecinDto medecinDto=new MedecinDto();
        BeanUtils.copyProperties(medecin,medecinDto);
        return medecinDto;
    }
    public Medecin fromMedecinDto(MedecinDto medecinDto){
        Medecin medecin=new Medecin();
        BeanUtils.copyProperties(medecinDto,medecin);
        return medecin;
    }
}
