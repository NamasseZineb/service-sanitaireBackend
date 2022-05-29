package ma.servicessanitaires.services.medecinService;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.MedecinDto;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.mappers.MedecinMapper;
import ma.servicessanitaires.repositories.MedecinRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class MedecinSerImpl implements MedecinSer {
    private MedecinRepo medecinRepo;
    private MedecinMapper medecinMapper;

    @Override
    public MedecinDto createMedecin(MedecinDto medecinDto){
        medecinDto.setImgUrl(setMedecinImgUrl());
        Medecin medecin=medecinMapper.fromMedecinDto(medecinDto);
        Medecin savedMedecin=medecinRepo.save(medecin);
        return medecinMapper.fromMedecin(medecin);
        /*
        Customer savedCustomer=customerRepository.save(customer);
        return dtoMapper.fromCustomer(customer);
         */
    }

    @Override
    public MedecinDto updateMedecin(MedecinDto MedecinDto) {
        Medecin medecin=medecinMapper.fromMedecinDto(MedecinDto);
        return medecinMapper.fromMedecin(medecinRepo.save(medecin));
    }

    @Override
    public List<MedecinDto> listMedecins() {
        List<Medecin> medecins = medecinRepo.findAll();
        List<MedecinDto> medecinDtos = medecins.stream()
                .map(medecin -> medecinMapper.fromMedecin(medecin))
                .collect(Collectors.toList());
        return medecinDtos;
    }

    @Override
    public MedecinDto getMedecin(Long id) throws MedecinNotFoundException {
        Medecin medecin = medecinRepo.findById(id)
                .orElseThrow(() -> new MedecinNotFoundException("Medecin inexistant"));
        return medecinMapper.fromMedecin(medecin) ;
    }

    @Override
    public Medecin Connect(String email, String pwd) {
        return medecinRepo.findByEmailAndPwd(email,pwd);
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepo.deleteById(id);
    }

    private String setMedecinImgUrl() {
        String imgNames = "logo_main.png";
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/medecin/img/"+imgNames).toUriString();
    }
}
