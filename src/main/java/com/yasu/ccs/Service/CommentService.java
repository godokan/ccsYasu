package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.BoardCommentDto;
import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Repository.BoardFreeCommentRepository;
import com.yasu.ccs.Domain.Repository.BoardFreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private BoardFreeCommentRepository boardFreeCommentRepository;
    @Autowired
    private BoardFreeRepository boardFreeRepository;

    public List<BoardCommentDto> getComments(Integer no) {
        List<BoardFreeCommentEntity> entities = boardFreeCommentRepository.findByBoardNo(no).orElse(null);
        List<BoardCommentDto> dtoList = new ArrayList<>();
        if (entities!=null) {
            for (BoardFreeCommentEntity entity : entities) {
                dtoList.add(entity.toDto());
            }
        } else {
            dtoList.add(BoardCommentDto
                    .builder()
                    .no(-1)
                    .context("댓글 없음")
                    .build());
        }

        return dtoList;
    }

    public BoardFreeCommentEntity newComment(BoardFreeEntity boardFree, String context) {

        BoardFreeCommentEntity entity = BoardFreeCommentEntity.builder()
                .boardNo(boardFree.getNo())
                .context(context)
                .build();

        return boardFreeCommentRepository.save(entity);
    }
}