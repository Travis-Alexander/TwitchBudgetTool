package com.example.TwitchBudgetTool.Equipmment;



import java.util.List;

import com.example.TwitchBudgetTool.Equipmment.EquipmentRepo;
import com.example.TwitchBudgetTool.Equipmment.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipmentService {

    @Autowired
    private EquipmentRepo repo;

    public List<Equipment> listAll(long ID) {
        return repo.findAllEquipment(ID);
    }

    public void save(Equipment equipment) {
        repo.save(equipment);
    }

    public Equipment get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}