package ma.servicessanitaires.mappers;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedecinDto;
import ma.servicessanitaires.entities.Image;
import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.repositories.ImageRepo;
import ma.servicessanitaires.repositories.MedecinRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ma.servicessanitaires.entities.*;

@Service
@AllArgsConstructor
public class MedecinMapper {

    private ImageRepo imageRepo;
    public MedecinDto fromMedecin(Medecin medecin){
        MedecinDto medecinDto=new MedecinDto();
        BeanUtils.copyProperties(medecin,medecinDto);
        return medecinDto;
    }
    public Medecin fromMedecinDto(MedecinDto medecinDto){
        Medecin medecin=new Medecin();
        Image image = imageRepo.findById(medecinDto.getImageId()).orElse(null);
        BeanUtils.copyProperties(medecinDto,medecin);
        medecin.setImage(image);
        return medecin;
    }
}
