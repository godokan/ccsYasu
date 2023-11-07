package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.AlertDto;
import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Domain.Repository.ApiListRepository;
import com.yasu.ccs.Domain.Repository.ApiUserRepository;
import com.yasu.ccs.Service.UserService;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

//@RequestMapping

@Slf4j
@Controller
public class UserController {
    @Autowired
    HttpSession httpSession;

    @Autowired
    UserService userService;
    CcsUserDto userDto;
    AlertDto alertDto;

    // 로그인
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginPost(@RequestBody Map<String, Object> user, HttpServletRequest request) {
        userDto = CcsUserDto.builder()
                .id(String.valueOf(user.get("id")))
                .pw(String.valueOf(user.get("pw")))
                .build();

        CcsUserDto findDto = userService.login(userDto);

        if (findDto == null) {
            return "ERR";
        }

        if (Objects.equals(findDto.getName(), "PW_NOT_MATCHES")) {
            return "PW_ERR";
        }

        httpSession = request.getSession(true);
        httpSession.setAttribute(SessionConst.LOGIN_USER, findDto);

        log.info("유저 : " + findDto.getName()+ " / " + findDto.getId() + "로그인");

        return "OK";
    }

    //로그아웃
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        httpSession = request.getSession(false);
        if (httpSession != null) // 세션 있으면
            httpSession.invalidate();

        alertDto = AlertDto.builder()
                .message("로그아웃 되었습니다.")
                .redirectUrl("home")
                .build();

        model.addAttribute("message", alertDto.getMessage());
        model.addAttribute("redirectUrl", alertDto.getRedirectUrl());

        return "message";
    }

    // 회원가입
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signupPost(@RequestBody Map<String, Object> user) {
        log.info("/signup : " + user.get("id") + " / " + user.get("pw") + " Posted");

        userDto = CcsUserDto.builder()
                .studNum(Integer.valueOf((String) user.get("hackbon")))
                .id(String.valueOf(user.get("id")))
                .pw(String.valueOf(user.get("pw")))
                .name(String.valueOf(user.get("nickname")))
                .build();

        log.info("유저 : " + userDto.getName()+ " / " + userDto.getId( )+ " / " + userDto.getPw() + "회원가입");

        if (userService.signIn(userDto))
            return "OK";
        else
            return "ERR";
    }

    @PostMapping("/chkIdDuplicate")
    @ResponseBody
    public String chkIdDuplicate(@RequestBody Map<String, Object> id) {
        log.info("/chkIdDuplicate : " + id.get("id") + " Posted");

        userDto = CcsUserDto.builder()
                .id(String.valueOf(id.get("id")))
                .build();

        if (!userService.findId(userDto))
            return "OK";
        else
            return "ERR";
    }

    // 내 정보 페이지

    @Autowired
    private ApiUserRepository apiUserRepository;

    @GetMapping("/my_apis")
    public String showMyApis(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/home")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        // 여기에 로직 작성 : API USER DB 로부터d 학번으로 조회.
        // DB 수정 필요 : 외래키 api_user와 api_list 간 관계, api_list_*와 api_list 간 관계 필요.

        return "my-api";
    }
}
