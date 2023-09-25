package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class YasuController {
    @Autowired
    HttpSession session;
    CcsUserDto userDto;

    @RequestMapping("/")
    public String index() {
            return "redirect:/home";
    }

    // GET Method

    @GetMapping("/home")
    public String home(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser==null) {
            return "index";
        } else
            userDto = sessionUser;

        model.addAttribute("hakbon", userDto.getStudNum());
        model.addAttribute("name", userDto.getName());
        model.addAttribute("id", userDto.getId());

        return "index_user";
    }
}
