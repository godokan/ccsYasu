package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.BoardCommentDto;
import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import com.yasu.ccs.Domain.Repository.BoardFreeCommentRepository;
import com.yasu.ccs.Domain.Repository.BoardFreeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    @Autowired
    private BoardFreeCommentRepository boardFreeCommentRepository;
    @Autowired
    private BoardFreeRepository boardFreeRepository;

    public List<BoardFreeCommentEntity> comments(Integer no) {
        List<BoardFreeCommentEntity> entitys = boardFreeCommentRepository.findByFreeBoardId(no);

        List<BoardCommentDto> dtos = new ArrayList<BoardCommentDto>();
        for (int i = 0; i < entitys.size(); i++) {
            BoardFreeCommentEntity c = entitys.get(i);
            BoardCommentDto dto = BoardCommentDto.createBoardCommentDto(c);
            dtos.add(dto);
        }
    }
}
