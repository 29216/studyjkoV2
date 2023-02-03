package app.studyjko.data.cd;

import app.studyjko.Utils.ConversionUtil;
import app.studyjko.data.user.UserDto;
import app.studyjko.data.user.UserRepository;
import app.studyjko.model.CdEntity;
import app.studyjko.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CdService {
    @Autowired
    private CdRepository cdRepository;

    public void save(CdDto cdDto) {
        cdRepository.save(mapDtoToEntity(cdDto));
    }
    public CdEntity mapDtoToEntity(CdDto cdDto) {
        return (CdEntity) ConversionUtil.mapObject(cdDto, CdEntity.class);
    }

    public CdDto mapEntityToDto(CdEntity cdEntity) {
        return (CdDto) ConversionUtil.mapObject(cdEntity, CdDto.class);
    }

    public List<CdEntity> findCdsByUserId(Long id){
        return cdRepository.findCdEntitiesByUserId(id);
    }
}
