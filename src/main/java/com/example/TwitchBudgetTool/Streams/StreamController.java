package com.example.TwitchBudgetTool.Streams;


import com.example.TwitchBudgetTool.Users.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StreamController {
    @Autowired
    private StreamsService service;


    @RequestMapping("/new_stream")
    public String showNewProductPage(Model model) {
        Streams stream = new Streams();
        model.addAttribute("streams", stream);

        return "create_stream";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveProduct(Streams stream, @AuthenticationPrincipal CustomUserDetails userDetails) {
        Long authorID = userDetails.getID();
        stream.setAuthor_id(authorID);
        service.save(stream);

        return "redirect:/streams";
    }

    @RequestMapping("/streams")
    public String viewStreams(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        List<Streams> listStreams = service.listAll(userDetails.getID());
        model.addAttribute("listStreams", listStreams);

        return "streams";
    }
    @RequestMapping("/edit/stream/{id}")
    public ModelAndView editStream(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_stream");
        Streams stream = service.get(id);
        mav.addObject("streams", stream);

        return mav;
    }

    @RequestMapping(value = "/editSave", method = RequestMethod.POST)
    public String edit(Streams newStream) {
        Streams oldStream = service.get(newStream.getId());// this will load the existing animal
        oldStream.setDay(newStream.getDay());
        oldStream.setTime(newStream.getTime());
        oldStream.setEarnings(newStream.getEarnings());

        // do the rest of the updates
        service.save(oldStream);
        return "redirect:/streams";
    }
}
