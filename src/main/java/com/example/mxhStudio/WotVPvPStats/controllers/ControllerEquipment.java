package com.example.mxhStudio.WotVPvPStats.controllers;

import com.example.mxhStudio.WotVPvPStats.domain.Equipment;
import com.example.mxhStudio.WotVPvPStats.projections.dto.EquipmentDTO;
import com.example.mxhStudio.WotVPvPStats.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/equipments")
public class ControllerEquipment {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping(value = "/all")
    public List<Equipment> findAll(){
        return equipmentService.findAll();
    }

    @GetMapping(value = "/{id}")
    public EquipmentDTO findById(@PathVariable Long id){
        return equipmentService.findById(id);
    }
}
