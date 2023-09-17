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
    @ResponseBody
    public String loginPost(@RequestBody Map<String, Object> user) {
        System.out.println(user);
        return "OK";
    }
}
