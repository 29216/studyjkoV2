package app.studyjko.data.parms;

import app.studyjko.Utils.ConversionUtil;
import app.studyjko.data.cd.CdDto;
import app.studyjko.model.CdEntity;
import app.studyjko.model.ParmsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParmsService {
    private final ParmsRepository parmsRepository;

    public void save(ParmsDto parmsDto) {
        parmsRepository.save(mapDtoToEntity(parmsDto));
    }
    public ParmsEntity mapDtoToEntity(ParmsDto cdDto) {
        return (ParmsEntity) ConversionUtil.mapObject(cdDto, ParmsEntity.class);
    }

    public ParmsDto mapEntityToDto(ParmsEntity cdEntity) {
        return (ParmsDto) ConversionUtil.mapObject(cdEntity, ParmsDto.class);
    }

    public ParmsDto getParmsByName(String name){
        return mapEntityToDto(parmsRepository.findParmsEntityByName(name));
    }

    public void saveNewRules(String rules) {
        ParmsEntity parmsEntity = parmsRepository.findParmsEntityByName("rules");
        if (parmsEntity != null) {
            parmsEntity.setValue(rules);
            save(mapEntityToDto(parmsEntity));
        } else {
            ParmsDto parmsDto = new ParmsDto();
            parmsDto.setName("rules");
            parmsDto.setValue(rules);
            save(parmsDto);
        }
    }

}
