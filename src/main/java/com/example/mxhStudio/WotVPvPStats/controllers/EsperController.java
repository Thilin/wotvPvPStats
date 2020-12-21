package com.example.mxhStudio.WotVPvPStats.controllers;

import com.example.mxhStudio.WotVPvPStats.domain.Esper;
import com.example.mxhStudio.WotVPvPStats.projections.dto.EsperDTO;
import com.example.mxhStudio.WotVPvPStats.services.EsperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/espers")
public class EsperController {

    @Autowired
    private EsperService esperService;

    @GetMapping(value = "/all")
    public List<Esper> listAll(){
        return esperService.findAll();
    }

    @GetMapping(value = "/{id}")
    public EsperDTO findById(@PathVariable Long id){
        return esperService.findById(id);
    }
}
