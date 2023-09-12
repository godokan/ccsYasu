package com.yasu.ccs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YasuController {
    @GetMapping("login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("signup")
    public String signup(Model model) {
        return "signup";
    }

    @GetMapping("notice")
    public String notice(Model model) {
        return "notice-board";
    }

    @GetMapping("freeboard")
    public String freeBoard(Model model) {
        return "free-board";
    }
}
