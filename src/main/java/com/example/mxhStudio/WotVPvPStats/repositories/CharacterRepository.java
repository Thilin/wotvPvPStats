package com.example.mxhStudio.WotVPvPStats.repositories;

import com.example.mxhStudio.WotVPvPStats.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
