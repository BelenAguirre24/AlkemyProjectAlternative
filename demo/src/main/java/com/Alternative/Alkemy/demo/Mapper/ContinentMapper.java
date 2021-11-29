package com.Alternative.Alkemy.demo.Mapper;

import com.Alternative.Alkemy.demo.DTO.ContinentDTO;
import com.Alternative.Alkemy.demo.Entity.EntityContinent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ContinentMapper {

    public EntityContinent ContinentDTO2Entity(ContinentDTO dto) {
        EntityContinent Entitycontinent = new EntityContinent();

        Entitycontinent .setImage(dto.getImage());
        Entitycontinent .setDenomination(dto.getDenomination());
         return  Entitycontinent ;



    }
    public ContinentDTO continentEntity2DTO (EntityContinent entity) {
    ContinentDTO dto = new ContinentDTO();
    dto.setId(entity.getId());
    dto.setImage(entity.getImage());
    dto.setDenomination(entity.getDenomination());
    return dto;

    }
public List <ContinentDTO> continentEntityList2DTOList(List<EntityContinent>entities){
        List <ContinentDTO> dtos = new ArrayList<>();
        for (EntityContinent entity:entities){
            dtos.add(this.continentEntity2DTO(entity));
        }
    return dtos;
}

}




