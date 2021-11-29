package com.Alternative.Alkemy.demo.Controller;

import com.Alternative.Alkemy.demo.DTO.ContinentDTO;
import com.Alternative.Alkemy.demo.Service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("continents")
public class ContinentController {
    @Autowired
    private ContinentService continentservice;
    @GetMapping
    public ResponseEntity <List<ContinentDTO>> getAll(){
        List<ContinentDTO> continents = this.continentservice.getAllContinents();
        return ResponseEntity.ok().body(continents);
    }

    @PostMapping
    public ResponseEntity <ContinentDTO>save (@RequestBody ContinentDTO Continent){
        ContinentDTO continentSave = continentservice.save(Continent);
        return ResponseEntity.status(HttpStatus.CREATED).body(continentSave);

    }
}
