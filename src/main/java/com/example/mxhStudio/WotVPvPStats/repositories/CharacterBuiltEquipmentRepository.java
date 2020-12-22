package com.example.mxhStudio.WotVPvPStats.repositories;

import com.example.mxhStudio.WotVPvPStats.domain.CharacterBuiltEquipments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltEquipmentRepository extends JpaRepository<CharacterBuiltEquipments, Long> {
    List<CharacterBuiltEquipments> findByCharacterBuiltId(Long id);
}
