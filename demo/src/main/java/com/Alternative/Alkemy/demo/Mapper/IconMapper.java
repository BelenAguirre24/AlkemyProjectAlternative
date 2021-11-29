package com.Alternative.Alkemy.demo.Mapper;

import com.Alternative.Alkemy.demo.DTO.CountryDTO;
import com.Alternative.Alkemy.demo.DTO.IconBasicDTO;
import com.Alternative.Alkemy.demo.DTO.IconDTO;
import com.Alternative.Alkemy.demo.Entity.EntityIcons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class IconMapper {
    @Autowired
    private CountryMapper countryMapper;

    public EntityIcons iconDTO2Entity(IconDTO dto) {
        EntityIcons entity = new EntityIcons();
        entity.setImage(dto.getImage());
        entity.setDenomination(dto.getDenomination());
        entity.setCreationDate(this.string2LocalDate(dto.getCreationdate()));
        entity.setHeight(dto.getHeight());
        entity.setHistory(dto.getHistory());
        return entity;
    }

    public IconDTO iconEntity2DTO(EntityIcons entity, boolean loadCountry) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setCreationdate(entity.getCreationDate().toString());
        dto.setHeight(entity.getHeight());
        dto.setHistory(entity.getHistory());
        if(loadCountry){
            List<CountryDTO> countrysDTO= this.countryMapper.EntitycountryList2DTOList(entity.getCountry()),loadicons: false
            dto.setCountry(countrysDTO);
        }
        return dto;
    }
    private LocalDate string2LocalDate(String stringDate){
        DateTimeFormat format = DateTimeFormat.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate ,formater);
        return date;
    }
    public void iconEntityRefreshValues(EntityIcons entity,IconDTO iconDTO){
        entity.setImage(iconDTO.getImage());
        entity.setDenomination(iconDTO.getDenomination());
        entity.setCreationDate(this.string2LocalDate(iconDTO.getCreationdate()));
        entity.setHeight(iconDTO.getHeight());
        entity.setHistory(iconDTO.getHistory());
    }
    public Set<EntityIcons> IconDTO iconDTOList2Entity (List<IconDTO> dtos {
        Set<EntityIcons> entities = new HashSet<>();
        for (IconDTO dto: dtos) {
            entities.add(this.iconDTO2Entity(dto));
        }
        return entities;
    }
    /**
     * @Param entities(set or List)
    * @param loadCountry
    */
    public List<IconDTO> iconEntitySet2DTOList (Collection<EntityIcons>entities, boolean loadCountry){
        List<IconDTO> dtos = new ArrayList<>();
        for (EntityIcons entity: entities) {
            dtos.add(this.iconEntity2DTO(entity,loadCountry));
        }
        return  dtos;
    }
    public List<IconBasicDTO> iconEntitySetBasicDTOList (Collection<EntityIcons>entities){
        List<IconBasicDTO> dtos = new ArrayList();
        IconBasicDTO basicDTO;
        for (EntityIcons entity: entities) {
            basicDTO = new IconBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.getImage(entity.getImage());
            basicDTO.getDenomination(entity.getDenomination());
            dtos.add(basicDTO);
        }
        return dtos;
    }
}


