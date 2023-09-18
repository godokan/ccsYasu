package com.yasu.ccs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YasuController {

    @RequestMapping("/")
    public String index() {
            return "redirect:/home";
    }

    // GET Method

    @GetMapping("/home")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/notice")
    public String notice(Model model) {
        return "notice-board";
    }

    @GetMapping("/freeboard")
    public String freeBoard(Model model) {
        return "free-board";
    }
}
