package com.Alternative.Alkemy.demo.Controller;

import com.Alternative.Alkemy.demo.DTO.IconBasicDTO;
import com.Alternative.Alkemy.demo.DTO.IconDTO;
import com.Alternative.Alkemy.demo.Service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping ("icons")
public class IconController {
    private IconService iconService{this.iconService = iconService}
    @Autowired
    public IconController (IconService iconService){this.iconService = iconService;}
    @GetMapping ("/all")
    public ResponseEntity <List<IconBasicDTO>>.getAll(){
        List <IconBasicDTO> icon = this.iconService.getAll();
        return ResponseEntity.ok(icon);
        }
    @GetMapping("/{id}")
    public ResponseEntity <IconDTO> getDetailsById(@PathVariable Long id){
        IconDTO icon = this.iconService.getDetailsById(id);
        return ResponseEntity.ok(icon);
        }
     @GetMapping
     public ResponseEntity <List<IconDTO>>getDetailsByFilters(){
         @RequestParam(required = false) String name,
         @RequestParam(required = false) String date,
         @RequestParam(required = false) Set<Long> cities,
         @RequestParam(required = false, defaultValue = "ASC") String order)
         {
             List<IconDTO> icons = this.iconService>getDetailsByFilters(name,date,cities,order);

             return ResponseEntity.ok(icons);
    }
    @PostMapping
    public ResponseEntity <IconDTO> save (@RequestBody IconDTO icon){
        IconDTO result = this.iconService.save (icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping ("/{id}")
    public ResponseEntity <IconDTO> update (@PathVariable Long id,@RequestBody IconDTO icon){
        IconDTO result = this.iconService.update (id, icon);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long Id){
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping("/{id}/country/{idCountry}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>addCountry (@PathVariable Long id,@PathVariable Long idCountry){
        this.iconService.addCountry(id,idCountry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping( @PostMapping("/{id}/country/{idCountry}"))
    public ResponseEntity <Void> removeCountry(@PathVariable Long id,@PathVariable Long idCountry) {
        this.iconService.removeCountry(id, idCountry);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

