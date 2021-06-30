package com.example.TwitchBudgetTool;

import com.example.TwitchBudgetTool.Users.CustomUserDetails;
import com.example.TwitchBudgetTool.Users.UserRepo;
import com.example.TwitchBudgetTool.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class Home {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String homeController(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {

//        Optional<Users> currUser = userRepo.findById(userDetails.getID());
//        Users currentUser;
//        if (currUser.isPresent()) {
//            currentUser = currUser.get();
//            model.addAttribute("user", currentUser);
//        }
        return "home";
    }
}


