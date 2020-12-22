package com.example.mxhStudio.WotVPvPStats.repositories;

import com.example.mxhStudio.WotVPvPStats.domain.CharacterJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterJobRepository extends JpaRepository<CharacterJob, Long> {
    List<CharacterJob> findByCharacterId(Long id);
}
