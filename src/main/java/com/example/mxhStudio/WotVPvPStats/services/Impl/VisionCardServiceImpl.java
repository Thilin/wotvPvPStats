package com.example.mxhStudio.WotVPvPStats.services.Impl;

import com.example.mxhStudio.WotVPvPStats.domain.VisionCard;
import com.example.mxhStudio.WotVPvPStats.exceptions.ObjectNotFoundException;
import com.example.mxhStudio.WotVPvPStats.projections.dto.VisionCardDTO;
import com.example.mxhStudio.WotVPvPStats.projections.views.VisionCardView;
import com.example.mxhStudio.WotVPvPStats.repositories.VisionCardRepository;
import com.example.mxhStudio.WotVPvPStats.services.VisionCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisionCardServiceImpl implements VisionCardService {

    @Autowired
    private VisionCardRepository visionCardRepository;

    @Override
    public List<VisionCard> listAll() {
        return visionCardRepository.findAll();
    }

    @Override
    public VisionCardDTO findById(Long id) {
        var visionCard = visionCardRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Visioncard Not Found"));
        var dto = new VisionCardDTO();
        dto.setId(visionCard.getId());
        dto.setName(visionCard.getName());
        dto.setImage(visionCard.getImage());
        return dto;
    }
}
