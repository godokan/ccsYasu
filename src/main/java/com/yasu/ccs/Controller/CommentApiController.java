package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.BoardCommentDto;
import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import com.yasu.ccs.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/freeboard/{no}/comment")
    public ResponseEntity<List<BoardCommentDto>> getBoardComments(@PathVariable Integer no) {
        List<BoardCommentDto> dtoList = commentService.getComments(no);
        if (dtoList.get(0).getNo()==-1)


        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }
}
