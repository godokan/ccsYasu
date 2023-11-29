package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.BoardCommentDto;
import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import com.yasu.ccs.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/freeboard/{no}/comments")
    public ResponseEntity<List<BoardCommentDto>> freeBoardComments(@PathVariable Integer no) {
        List<BoardFreeCommentEntity> dtos = commentService.comments(no);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
