package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.AlertDto;
import com.yasu.ccs.DTO.ApiListDto;
import com.yasu.ccs.DTO.BoardDto;
import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Repository.BoardFreeRepository;
import com.yasu.ccs.Service.BoardService;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
public class BoardController {
    @Autowired
    HttpSession session;

    @Autowired
    private BoardService boardService;

    private AlertDto alertDto;

    @Autowired
    private BoardFreeRepository boardFreeRepository;

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

        List<BoardDto> noticeEntities = boardService.getNoticeList();

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

        List<BoardDto> freeEntities = boardService.getFreeList();

        model.addAttribute("articleList", freeEntities);

        return "free-board";
    }

    @GetMapping("/freeboard/new")
    public String newFreeArticle() {
        return "/freeboard";
    }

    @PostMapping("/freeboard/create")
    public String createFreeArticle(BoardDto form) {
        BoardFreeEntity freeArticle = form.toBoardFreeEntity();
        BoardFreeEntity saved = boardFreeRepository.save(freeArticle);
        return "/freeboard";
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

        List<ApiListDto> apiListEntities = boardService.getApiList();
        model.addAttribute("apiList", apiListEntities);

        return "api-board";
    }

    // 게시판 작성 컨트롤러

    // 게시판 조회 컨트롤러 : 상세보기 페이지.

    @GetMapping("/notice/{no}")
    public String noticeDetail(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, @PathVariable Integer no, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/home")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }
        if(no == -1) {
            alertDto = AlertDto.builder()
                    .message("유효하지 않은 게시글입니다.")
                    .redirectUrl("/notice")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

//        BoardDto noticeDto = boardService.getDetailNotice(no);

        BoardDto noticeDto = BoardDto.builder().no(no).studNum(123456789).date("2023-11-13").context("캡스톤 디자인 프로젝트 어바웃송담 화이팅").build();
        model.addAttribute("articleList", noticeDto);

        return "notice-board-show";
    }
}
