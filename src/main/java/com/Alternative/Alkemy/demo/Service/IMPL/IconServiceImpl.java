package com.Alternative.Alkemy.demo.Service.impl;

import com.Alternative.Alkemy.demo.DTO.IconBasicDTO;
import com.Alternative.Alkemy.demo.DTO.IconDTO;
import com.Alternative.Alkemy.demo.DTO.IconFiltersDTO;
import com.Alternative.Alkemy.demo.Entity.EntityContinent;
import com.Alternative.Alkemy.demo.Entity.EntityCountry;
import com.Alternative.Alkemy.demo.Entity.EntityIcons;
import com.Alternative.Alkemy.demo.Excepction.ParamNotFound;
import com.Alternative.Alkemy.demo.Mapper.CountryMapper;
import com.Alternative.Alkemy.demo.Mapper.IconMapper;
import com.Alternative.Alkemy.demo.Repository.IconRepository;
import com.Alternative.Alkemy.demo.Repository.Specification.IconSpecification;
import com.Alternative.Alkemy.demo.Service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.OptionChecker;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IconServiceImpl implements IconService {
    //Repo
    private IconRepository iconRepository;
    private IconSpecification iconSpecification;
    //Mapper
    private IconMapper iconMapper;
    //Service
    private CountryService countryService;
    @Autowired
    public IconServiceImpl(
            IconRepository iconRepository,
            IconSpecification iconSpecification,
            CountryService countryService,
            IconMapper iconMapper){
        this.iconRepository = iconRepository;
        this.iconSpecification = iconSpecification;
        this.iconMapper = iconMapper;
        this.countryService = countryService;
    }
    public IconDTO getDetailsById (Long id){
        Optional<EntityIcons> entity = this.IconRepostory.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound("id icon not valide");


        }
        IconDTO iconDTO = this.iconMapper.iconEntity2DTO(entity.get(), true);
        return iconDTO;
    }
    public List<IconBasicDTO> getAll(){
    List<EntityIcons> entities = this.IconRepository.findAll();
    List<IconBasicDTO> iconBasicDTOS = this.iconMapper.iconEntitySetBasicDTOList(entities);
    return  iconBasicDTOS;
    }
    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order){
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
        List<EntityIcons> entities = this.iconRepository.findAll(this.iconSpecification.getByFilters(filtersDTO));
        List <IconDTO> dtos = this.iconMapper.iconEntitySet2DTOList(entities,true);
        return dtos;
    }
    public IconDTO save (IconDTO iconDTO){
        EntityIcons entity = this.iconMapper.iconDTO2Entity(iconDTO);
        EntityIcons entitySaved = this.iconRepository.save(entity);
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false);
        return result;
    }

    public IconDTO update (Long id, IconDTO iconDTO){
        Optional<EntityIcons> entity = this.iconRepository.findById(id);
        if (!entity.isPresent()){
            throw new ParamNotFound("id icon not valide");

        }





    public void addCountry(Long id, Long idCountry){
    EntityIcons entity = this.iconRepository.getById(id);
    entity.getCountry().size();
    EntityCountry entityCountry = this.CountryService.getEntityByIfd(idCountry);
    entity.addCountry(entityCountry);
    this.iconRepository.save (entity);
}
public void removeCountry(Long id, Long idCountry){
    EntityIcons entity = this.iconRepository.getById(id);
    entity.getCountry().size();
    EntityCountry entityCountry = this.CountryService.getEntityByIfd(idCountry);
    entity.removeCountry(entityCountry);
    this.iconRepository.save (entity);
}
public void     delete (Long id) {
    this.iconRepository.deleteById(id);
}
}