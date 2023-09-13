package com.yasu.ccs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginGet(Model model) {
        return "/login";
    }

    @PostMapping
    @ResponseBody
    public String  loginPost(@RequestBody Map<String,Object> map, Model model) {
        model.addAttribute("user_id", map);
        return "redirect:/home";
    }
}
