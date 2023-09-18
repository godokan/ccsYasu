package com.yasu.ccs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping
@Controller
public class SignupController {

    @GetMapping("/signup")
    public String login(Model model) {
        return "signup";
    }

    @PostMapping("/signupPost")
    @ResponseBody
    public String signupPost(@RequestBody Map<String, Object> user) {
        System.out.println(user);
        return "OK";
    }
}
