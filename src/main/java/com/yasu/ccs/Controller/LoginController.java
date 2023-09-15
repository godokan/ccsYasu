package com.yasu.ccs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/loginPost")
    public String  loginPost(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return "redirect:/home";
    }
}
