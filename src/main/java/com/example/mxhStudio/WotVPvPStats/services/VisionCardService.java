package com.example.mxhStudio.WotVPvPStats.services;

import com.example.mxhStudio.WotVPvPStats.domain.VisionCard;
import com.example.mxhStudio.WotVPvPStats.projections.dto.VisionCardDTO;
import com.example.mxhStudio.WotVPvPStats.projections.views.VisionCardView;

import java.util.List;

public interface VisionCardService {
    List<VisionCard> listAll();

    VisionCardDTO findById(Long id);
}
