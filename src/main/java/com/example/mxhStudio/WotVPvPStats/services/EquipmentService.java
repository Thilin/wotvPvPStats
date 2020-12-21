package com.example.mxhStudio.WotVPvPStats.services;

import com.example.mxhStudio.WotVPvPStats.domain.Equipment;
import com.example.mxhStudio.WotVPvPStats.projections.dto.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    List<Equipment> findAll();

    EquipmentDTO findById(Long id);
}
