package com.Alternative.Alkemy.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IconDTO {
    private Long id;
    private String image;
    private String denomination;
    private String creationdate;
    private Long height;
    private String history;
    private List<CountryDTO> country;
}
