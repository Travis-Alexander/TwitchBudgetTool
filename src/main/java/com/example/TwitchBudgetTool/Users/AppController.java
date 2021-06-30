package com.example.TwitchBudgetTool.Users;

import com.example.TwitchBudgetTool.Streams.Streams;
import com.example.TwitchBudgetTool.Users.UserRepo;
import com.example.TwitchBudgetTool.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // thanks Lance
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AppController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Users> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());

        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(Users user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/budget")
    public String budget(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        userRepo.showBalance(userDetails.getID()).getBalance();

        return "balance";
    }

//    public String viewStreams(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
//        List<Streams> listStreams = service.listAll(userDetails.getID());
//        model.addAttribute("listStreams", listStreams);
//
//        return "streams";
//    }
}