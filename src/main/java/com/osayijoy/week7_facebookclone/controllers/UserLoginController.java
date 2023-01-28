package com.osayijoy.week7_facebookclone.controllers;

import com.osayijoy.week7_facebookclone.models.User;
import com.osayijoy.week7_facebookclone.services.PostService;
import com.osayijoy.week7_facebookclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;


    @GetMapping("/")
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("invalidEmail", null);
        return "signUpAndLogin";
    }

    //Log in

    @PostMapping("/")
    public String login(User user, Model model, HttpSession httpSession){
        User newUser = userService.getUserByEmail(user.getEmail());
        if (newUser == null ){
            model.addAttribute("invalidEmail", "Email does not exist");
            return "signUpAndLogin";
        }
        newUser = userService.getuserByEmailAndPassWord(user.getEmail(), user.getPassword());
        if(newUser == null ){
            model.addAttribute("badPassword", "Incorrect password");
            return "signUpAndLogin";
        }
        httpSession.setAttribute("user", newUser);
        return "redirect:/home";
    }


    //Log Out
    @GetMapping("/logout")
    public String logout(Model model, HttpSession httpSession){
        if(httpSession != null){
            httpSession.invalidate();
        }
        model.addAttribute("user", new User());
        model.addAttribute("invalidEmail", null);
        return "redirect:/";
    }
}

