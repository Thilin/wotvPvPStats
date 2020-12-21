package com.example.mxhStudio.WotVPvPStats.services.Impl;

import com.example.mxhStudio.WotVPvPStats.domain.Equipment;
import com.example.mxhStudio.WotVPvPStats.exceptions.ObjectNotFoundException;
import com.example.mxhStudio.WotVPvPStats.projections.dto.EquipmentDTO;
import com.example.mxhStudio.WotVPvPStats.repositories.EquipmentRepository;
import com.example.mxhStudio.WotVPvPStats.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public EquipmentDTO findById(Long id) {
        var equipment = equipmentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Equipmaneto não encontrado"));
        var dto = new EquipmentDTO();
        dto.setId(equipment.getId());
        dto.setName(equipment.getName());
        dto.setImage(equipment.getImage());
        dto.setType(equipment.getEquipmentType().getDescription());
        return dto;
    }
}
