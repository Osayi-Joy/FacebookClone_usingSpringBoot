package com.osayijoy.week7_facebookclone.controllers;

import com.osayijoy.week7_facebookclone.models.User;
import com.osayijoy.week7_facebookclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserSignupController {
    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String getSignUpPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("thisPage", "Please Sign up");
        return "signUpAndLogin";
    }

    @PostMapping("/signup")
    public String signUp(@Validated User user, Model model){
        User newUser = userService.getUserByEmail(user.getEmail());
        if (newUser != null){
            model.addAttribute("thisPage", "user already exist");
            return "signUpAndLogin";
        }
        userService.registerUser(user);
        model.addAttribute("success","Registration successful");
        return "redirect:/signup";
    }

}
