package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.*;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Entity.BoardNoticeEntity;
import com.yasu.ccs.Service.ApiService;
import com.yasu.ccs.Service.BoardService;
import com.yasu.ccs.Service.CommentService;
import com.yasu.ccs.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class BoardController {
    @Autowired
    HttpSession session;

    @Autowired
    private BoardService boardService;

    @Autowired
    private ApiService apiService;

    @Autowired
    private CommentService commentService;

    private AlertDto alertDto;

    // 게시판 접속 컨트롤러

    @GetMapping("/notice")
    public String notice(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/login")
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
                    .redirectUrl("/login")
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

    @PostMapping("/freeboard/create")
    public String initToFreeBoard(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, String context, Model model) {
        BoardFreeEntity boardFree = boardService.initFreeBoard(sessionUser.toEntity(), context);
        if (boardFree!=null)
            return "redirect:/freeboard";
        else {
            alertDto = AlertDto.builder()
                    .message("게시글 작성에 문제가 발생횄습니다.")
                    .redirectUrl("/freeboard")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }
    }

    @GetMapping("/freeboard/{no}")
    public String freeboardDetail(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, @PathVariable Integer no, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/login")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }
        if(no == -1) {
            alertDto = AlertDto.builder()
                    .message("유효하지 않은 게시글입니다.")
                    .redirectUrl("/freeboard")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        BoardDto freeboardDto = boardService.getDetailFree(no);
        model.addAttribute("article", freeboardDto);

        List<BoardCommentDto> commentList = commentService.getComments(no);
        model.addAttribute("comments", commentList);

        return "free-board-show";
    }

    @PostMapping("/freeboard/{no}/comment")
    public String newComment(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, @PathVariable Integer no, String context, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/login")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        BoardCommentDto commentDto = commentService.newComment(no, context);
        if (commentDto!= null) {
            alertDto = AlertDto.builder()
                    .message("댓글이 작성 되었습니다.")
                    .redirectUrl("/freeboard/"+no)
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        alertDto = AlertDto.builder()
                .message("댓글 작성에 실패 했습니다.")
                .redirectUrl("/freeboard/"+no)
                .build();
        model.addAttribute("message", alertDto.getMessage());
        model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
        return "message";
    }

    @GetMapping("/apiboard")
    public String apiList(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/login")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        log.info("유저 : " + sessionUser.getName()+ " / " + sessionUser.getId() + "/apiboard 접속");

        List<ApiListDto> apiListEntities = apiService.getApiList();
        model.addAttribute("apiList", apiListEntities);

        return "api-board";
    }

    // 게시판 작성 컨트롤러

    // 게시판 조회 컨트롤러 : 상세보기 페이지.

    @PostMapping("/notice/create")
    public String initToNotice(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, String context, Model model) {
        if(sessionUser.getStudNum()==999999999) {
            BoardNoticeEntity boardNotice = boardService.initNoticeBoard(sessionUser.toEntity(), context);
            if (boardNotice != null)
                return "redirect:/notice";
            else {
                alertDto = AlertDto.builder()
                        .message("게시글 작성에 문제가 발생횄습니다.")
                        .redirectUrl("/notice")
                        .build();
                model.addAttribute("message", alertDto.getMessage());
                model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
                return "message";
            }
        } else {
            alertDto = AlertDto.builder()
                    .message("게시글 작성 권한이 없습니다.")
                    .redirectUrl("/notice")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }
    }

    @GetMapping("/notice/{no}")
    public String noticeDetail(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, @PathVariable Integer no, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/login")
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

        BoardDto noticeBoardDTO = boardService.getDetailNotice(no);
        model.addAttribute("article", noticeBoardDTO);

        return "notice-board-show";
    }

    @GetMapping("/apiboard/{id}")
    public String apiDetail(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, @PathVariable String id, Model model) {
        if (sessionUser == null) {
            alertDto = AlertDto.builder()
                    .message("로그인이 필요한 페이지입니다.")
                    .redirectUrl("/login")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        ApiListDto api = apiService.getApiById(id);
        model.addAttribute("api", api);

        return "api-show";
    }

    @PostMapping("/apiboard/{id}/issued")
    public String issue(@SessionAttribute(value = SessionConst.LOGIN_USER, required = false) CcsUserDto sessionUser, @PathVariable String id, Model model) {

        String user = apiService.getApiUser(sessionUser.getStudNum());
        if (user.equals("NF")) {
            alertDto = AlertDto.builder()
                    .message("API 계정을 찾을 수 없습니다. API 계정 발급 바랍니다.")
                    .redirectUrl("/api_user_create")
                    .build();
            model.addAttribute("message", alertDto.getMessage());
            model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
            return "message";
        }

        String issue = apiService.issueApiKey(sessionUser, id);

        alertDto = AlertDto.builder()
                .message(id+"의 API KEY가 발급되었습니다.")
                .redirectUrl("/my_apis")
                .build();
        model.addAttribute("message", alertDto.getMessage());
        model.addAttribute("redirectUrl", alertDto.getRedirectUrl());
        return "message";
    }
}
