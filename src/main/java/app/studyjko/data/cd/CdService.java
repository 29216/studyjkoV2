package app.studyjko.data.cd;

import app.studyjko.Utils.ConversionUtil;
import app.studyjko.model.CdEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CdService {
    private final CdRepository cdRepository;

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

    public CdEntity findCdById(Long id){
        return cdRepository.findById(id).orElse(null);
    }
}
