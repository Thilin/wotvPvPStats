package com.example.mxhStudio.WotVPvPStats.services.Impl;

import com.example.mxhStudio.WotVPvPStats.domain.Character;
import com.example.mxhStudio.WotVPvPStats.domain.CharacterJob;
import com.example.mxhStudio.WotVPvPStats.exceptions.ObjectNotFoundException;
import com.example.mxhStudio.WotVPvPStats.projections.dto.CharacterDTO;
import com.example.mxhStudio.WotVPvPStats.projections.dto.JobsCharacterDTO;
import com.example.mxhStudio.WotVPvPStats.projections.dto.JobsDTO;
import com.example.mxhStudio.WotVPvPStats.repositories.CharacterJobRepository;
import com.example.mxhStudio.WotVPvPStats.repositories.CharacterRepository;
import com.example.mxhStudio.WotVPvPStats.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterJobRepository characterJobRepository;

    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public CharacterDTO findById(Long id) {
        var character = characterRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Personagem não encontrado"));
        var dto = new CharacterDTO();
        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setImage(character.getImage());
        dto.setRarity(character.getRarity());
        return dto;
    }

    @Override
    public JobsCharacterDTO findCharacterJobsById(Long id) {

        List<CharacterJob> characterJobs = characterJobRepository.findByCharacterId(id);
        List<JobsDTO> jobsDTO = new ArrayList<>();
        var dto = new JobsCharacterDTO();

        characterJobs.forEach(characterJob -> {
            var job = new JobsDTO();
            dto.setName(characterJob.getCharacter().getName());
            job.setJob(characterJob.getJob().getDescription());
            job.setMain(characterJob.isMain());
            jobsDTO.add(job);
        });
        dto.setJobs(jobsDTO);
        return dto;
    }
}
