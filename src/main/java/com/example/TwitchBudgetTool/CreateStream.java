package com.example.TwitchBudgetTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CreateStream {
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
    public String viewStreams(Model model) {
        List<Streams> listStreams = service.listAll();
        model.addAttribute("listStreams", listStreams);

        return "streams";
    }
}
