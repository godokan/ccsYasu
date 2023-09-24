package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Service.UserService;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping
@Controller
public class UserController {
    HttpSession httpSession;

    @Autowired
    UserService userService;
    CcsUserDto userDto;

    // 로그인
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPost")
    @ResponseBody
    public String loginPost(@RequestBody Map<String, Object> user, HttpServletRequest request) {
        userDto = CcsUserDto.builder()
                .id(String.valueOf(user.get("id")))
                .pw(String.valueOf(user.get("pw")))
                .build();

        CcsUserDto findDto = userService.login(userDto);

        if (findDto != null) {
            httpSession = request.getSession(true);
            httpSession.setAttribute(SessionConst.LOGIN_USER, findDto);
            return "OK";
        }

        return "ERR";
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        httpSession = request.getSession(false);
        if (httpSession != null) // 세션 있으면
            httpSession.invalidate();
        return "redirect:/home";
    }

    // 회원가입
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signupPost")
    @ResponseBody
    public String signupPost(@RequestBody Map<String, Object> user) {
        System.out.println(user);

        userDto = CcsUserDto.builder()
                .studNum(Integer.valueOf((String) user.get("hackbon")))
                .id(String.valueOf(user.get("id")))
                .pw(String.valueOf(user.get("pw")))
                .name(String.valueOf(user.get("nickname")))
                .build();

        if (userService.signIn(userDto))
            return "OK";
        else
            return "ERR";
    }
}
