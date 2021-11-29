package com.Alternative.Alkemy.demo.Service;

import com.Alternative.Alkemy.demo.DTO.ContinentDTO;

import java.util.List;

public interface ContinentService {
    ContinentDTO save(ContinentDTO dto);
    List<ContinentDTO> getAllContinents();

}
