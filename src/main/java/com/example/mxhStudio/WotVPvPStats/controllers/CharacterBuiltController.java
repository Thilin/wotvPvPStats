package com.example.mxhStudio.WotVPvPStats.controllers;

import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterBuiltDTO;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterBuiltResponseDTO;
import com.example.mxhStudio.WotVPvPStats.services.CharacterBuiltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/characterbuilder")
public class CharacterBuiltController {

    @Autowired
    private CharacterBuiltService characterBuiltService;

    @PostMapping(value = "/create")
    public CharacterBuiltResponseDTO build(@RequestBody CharacterBuiltDTO dto){
        return characterBuiltService.build(dto);
    }

    @GetMapping(value = "/{id}")
    public CharacterBuiltResponseDTO findById(@PathVariable Long id){
        return characterBuiltService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<CharacterBuiltResponseDTO> findAll(){
        return characterBuiltService.findAll();
    }
}
