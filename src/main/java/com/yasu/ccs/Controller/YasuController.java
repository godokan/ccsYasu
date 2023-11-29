package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.AlertDto;
import com.yasu.ccs.DTO.BoardDto;
import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Service.BoardService;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class YasuController {
    @Autowired
    HttpSession session;
    CcsUserDto userDto;
    AlertDto alertDto;

    @Autowired
    BoardService boardService;

    @RequestMapping("/")
    public String index() {
            return "redirect:home";
    }

    // GET Method

    @GetMapping("/home")
    public String home(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {

        model.addAttribute("noticeList", boardService.getFiveNoticeList());
        model.addAttribute("freeList", boardService.getFiveFreeList());

        if (sessionUser==null) {
            return "index";
        } else
            userDto = sessionUser;

        model.addAttribute("hakbon", userDto.getStudNum());
        model.addAttribute("name", userDto.getName());
        model.addAttribute("id", userDto.getId());

        return "index_user";
    }

    @GetMapping("/profile")
    public String profile(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("home")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }
        model.addAttribute("name", sessionUser.getName());
        model.addAttribute("id", sessionUser.getId());
        model.addAttribute("hackbon", sessionUser.getStudNum());
        return "my";
    }

    @GetMapping("/releases")
    public String releases() {
        return "releases";
    }

}
