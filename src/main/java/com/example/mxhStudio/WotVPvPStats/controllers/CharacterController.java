package com.example.mxhStudio.WotVPvPStats.controllers;

import com.example.mxhStudio.WotVPvPStats.domain.Character;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterDTO;
import com.example.mxhStudio.WotVPvPStats.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/all")
    public List<Character> findAll(){
        return characterService.findAll();
    }

    @GetMapping(value = "/{id}")
    public CharacterDTO findById(@PathVariable Long id){
        return characterService.findById(id);
    }
}
