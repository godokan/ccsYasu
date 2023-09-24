package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YasuController {

    HttpSession httpSession;
    CcsUserDto userDto;

    @RequestMapping("/")
    public String index() {
            return "redirect:/home";
    }

    // GET Method

    @GetMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        httpSession = request.getSession(false);
        if (httpSession==null) {
            return "index";
        }

        userDto = (CcsUserDto) httpSession.getAttribute(SessionConst.LOGIN_USER);
        if (userDto==null) {
            return "index";
        }

        model.addAttribute("hakbon", userDto.getStudNum());
        model.addAttribute("name", userDto.getName());
        model.addAttribute("id", userDto.getId());

        return "index_user";
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
