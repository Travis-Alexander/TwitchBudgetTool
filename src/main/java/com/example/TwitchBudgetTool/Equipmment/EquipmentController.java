package com.example.TwitchBudgetTool.Equipmment;

import com.example.TwitchBudgetTool.Streams.Streams;
import com.example.TwitchBudgetTool.Streams.StreamsService;
import com.example.TwitchBudgetTool.Users.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.TwitchBudgetTool.Streams.StreamController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentService service;

    @Autowired
    StreamsService streamsService;


    @RequestMapping("/new_equipment")
    public String showNewEquipmentPage(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);

        return "create_equipment";
    }

    @RequestMapping(value = "/saveEquipment", method = RequestMethod.POST)
    public String saveEquipment(Equipment equipment, @AuthenticationPrincipal CustomUserDetails userDetails) {
        Long authorID = userDetails.getID();
        equipment.setAuthor_id(authorID);
        service.save(equipment);

        return "redirect:/equipment";
    }

    @RequestMapping("/equipment")
    public String viewStreams(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        List<Equipment> listEquipment = service.listAll(userDetails.getID());
        List<Streams> listStreams = streamsService.listAll(userDetails.getID());

        model.addAttribute("listEquipment", listEquipment);
        model.addAttribute("listStreams", listStreams);
        double totalBalance = 0;
        for (Streams stream : listStreams) {
            double dailyEarning = stream.getEarnings();
            totalBalance += dailyEarning;
        }

        for (Equipment equipment : listEquipment) {
            double equipmentCost = equipment.getCost();
            String canBuy = "You can buy this item";
            double difference = equipmentCost - totalBalance;
            System.out.println(totalBalance + " " + difference);

            if (difference <= 0) {
                equipment.setProgress(canBuy);
                service.save(equipment);
            } else {
                equipment.setProgress(Double.toString(difference));
                service.save(equipment);
            }

        }


        return "equipment";
    }

    @RequestMapping("/edit/equipment/{id}")
    public ModelAndView editEquipment(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_equipment");
        Equipment equipment = service.get(id);
        mav.addObject("equipment", equipment);

        return mav;
    }

    @RequestMapping(value = "/editEquipmentSave", method = RequestMethod.POST)
    public String edit(Equipment newEquipment) {
        Equipment oldEquipment = service.get(newEquipment.getId());// this will load the existing animal
        oldEquipment.setName(newEquipment.getName());
        oldEquipment.setCost(newEquipment.getCost());


        // do the rest of the updates
        service.save(oldEquipment);
        return "redirect:/equipment";
    }

    @RequestMapping("/delete/equipment/{id}")
    public String deleteEquipment(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/equipment";
    }
}
