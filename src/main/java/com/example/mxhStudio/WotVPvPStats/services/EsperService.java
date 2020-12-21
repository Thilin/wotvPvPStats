package com.example.mxhStudio.WotVPvPStats.services;

import com.example.mxhStudio.WotVPvPStats.domain.Esper;
import com.example.mxhStudio.WotVPvPStats.projections.dto.EsperDTO;

import java.util.List;

public interface EsperService {
    List<Esper> findAll();

    EsperDTO findById(Long id);
}
