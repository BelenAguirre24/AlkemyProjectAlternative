package com.Alternative.Alkemy.demo.Service;

import com.Alternative.Alkemy.demo.DTO.IconBasicDTO;
import com.Alternative.Alkemy.demo.DTO.IconDTO;

import java.util.List;
import java.util.Set;

public interface IconService {
    IconDTO getDetailById (Long id);
    List<IconBasicDTO>getAll();
    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);
    IconDTO save (IconDTO iconDTO);
    IconDTO update(Long id, IconDTO icon);
    void addCountry(Long id,Long idCountry);
    void removeCountry (Long id,Long idCountry);
    void delete (Long id);

}
