package com.example.mxhStudio.WotVPvPStats.services.Impl;

import com.example.mxhStudio.WotVPvPStats.domain.Esper;
import com.example.mxhStudio.WotVPvPStats.exceptions.ObjectNotFoundException;
import com.example.mxhStudio.WotVPvPStats.projections.dto.EsperDTO;
import com.example.mxhStudio.WotVPvPStats.repositories.EsperRepository;
import com.example.mxhStudio.WotVPvPStats.services.EsperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsperServiceImpl implements EsperService {

    @Autowired
    private EsperRepository esperRepository;

    @Override
    public List<Esper> findAll() {
        return esperRepository.findAll();
    }

    @Override
    public EsperDTO findById(Long id) {
        var esper = esperRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Esper não encontrado"));
        var dto = new EsperDTO();
        dto.setId(esper.getId());
        dto.setImage(esper.getImage());
        dto.setName(esper.getName());
        return dto;
    }
}
