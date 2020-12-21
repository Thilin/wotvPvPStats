package com.example.mxhStudio.WotVPvPStats.controllers;

import com.example.mxhStudio.WotVPvPStats.domain.VisionCard;
import com.example.mxhStudio.WotVPvPStats.projections.views.VisionCardView;
import com.example.mxhStudio.WotVPvPStats.services.VisionCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mxhStudio.WotVPvPStats.projections.dto.VisionCardDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/visioncards")
public class VisionCardController {

    @Autowired
    VisionCardService visionCardService;

    @GetMapping(value = "/all")
    public List<VisionCard> listAll(){
        return visionCardService.listAll();
    }

    @GetMapping(value = "/{id}")

    public VisionCardDTO findById(@PathVariable Long id){
        return visionCardService.findById(id);
    }
}
