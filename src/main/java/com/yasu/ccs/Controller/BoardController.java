package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.AlertDto;
import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Domain.Entity.ApiListEntity;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Entity.BoardNoticeEntity;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import com.yasu.ccs.Domain.Repository.ApiListRepository;
import com.yasu.ccs.Domain.Repository.BoardFreeRepository;
import com.yasu.ccs.Domain.Repository.BoardNoticeRepository;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
public class BoardController {
    @Autowired
    HttpSession session;

    @Autowired
    private BoardFreeRepository freeRepository;
    @Autowired
    private BoardNoticeRepository noticeRepository;
    @Autowired
    private ApiListRepository apiListRepository;

    AlertDto alertDto;

    // 게시판 접속 컨트롤러

    @GetMapping("/notice")
    public String notice(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/home")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        log.info("유저 : " + sessionUser.getName()+ " / " + sessionUser.getId() + "/notice 접속");

        List<BoardNoticeEntity> noticeEntities = noticeRepository.findAll();

        model.addAttribute("articleList", noticeEntities);

        return "notice-board";
    }

    @GetMapping("/freeboard")
    public String freeBoard(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/home")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        log.info("유저 : " + sessionUser.getName()+ " / " + sessionUser.getId() + "/freeboard 접속");

        List<BoardFreeEntity> freeEntities = freeRepository.findAll();

        model.addAttribute("articleList", freeEntities);

        return "free-board";
    }

    @GetMapping("/apiboard")
    public String apiList(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/home")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        log.info("유저 : " + sessionUser.getName()+ " / " + sessionUser.getId() + "/apiboard 접속");

        List<ApiListEntity> apiListEntities = apiListRepository.findAll();
        model.addAttribute("apiList", apiListEntities);

        return "api-board";
    }

    // 게시판 작성 컨트롤러

    // 게시판 조회 컨트롤러
}
