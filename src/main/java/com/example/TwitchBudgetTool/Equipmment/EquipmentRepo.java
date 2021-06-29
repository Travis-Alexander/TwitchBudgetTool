package com.example.TwitchBudgetTool.Equipmment;
import com.example.TwitchBudgetTool.Streams.Streams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentRepo extends JpaRepository<Equipment, Long> {
    @Query("SELECT e FROM Equipment e WHERE e.author_id = ?1")
    public List<Equipment> findAllEquipment(long ID);
}
