package com.Alternative.Alkemy.demo.Service.impl;
import com.Alternative.Alkemy.demo.DTO.ContinentDTO;
import com.Alternative.Alkemy.demo.Entity.EntityContinent;
import com.Alternative.Alkemy.demo.Mapper.ContinentMapper;
import com.Alternative.Alkemy.demo.Repository.ContinentRepository;
import com.Alternative.Alkemy.demo.Service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContinentServiceImpl implements ContinentService {
    @Autowired
    private ContinentMapper continentMapper;
    @Autowired
    private ContinentRepository continentRepository;
    public ContinentDTO save (ContinentDTO dto) {
        EntityContinent entity = continentMapper.ContinentDTO2Entity(dto);
        EntityContinent entitySaved = continentRepository.save(entity);
        ContinentDTO Result = continentMapper.continentEntity2DTO(entitySaved);
        return Result;

    }

    public List<ContinentDTO> getAllContinents(){
        List<EntityContinent> entities = this.continentRepository.findAll();
        List<ContinentDTO> result = this.continentMapper.continentEntityList2DTOList(entities);
        return result;
    }
}