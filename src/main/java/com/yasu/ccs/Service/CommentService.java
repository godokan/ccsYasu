package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.BoardCommentDto;
import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Repository.BoardFreeCommentRepository;
import com.yasu.ccs.Domain.Repository.BoardFreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private BoardFreeCommentRepository boardFreeCommentRepository;
    @Autowired
    private BoardFreeRepository boardFreeRepository;

    public List<BoardCommentDto> getComments(Integer no) {
        System.out.println("getComments");
        List<BoardFreeCommentEntity> entities = boardFreeCommentRepository.findAllByBoardNo(no).orElse(null);
        List<BoardCommentDto> dtoList = new ArrayList<>();
        if (entities!=null) {
            for (BoardFreeCommentEntity entity : entities) {
                dtoList.add(entity.toDto());
            }
        } else {
            return null;
        }

        return dtoList;
    }

    // 컨트롤러에서 : if문에서 null 검사하고 !null 이면 작동, null이면 abort
    public BoardCommentDto newComment(Integer no, String context) {
        LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

        BoardFreeEntity boardFree = boardFreeRepository.findById(no).orElse(null);
        if (boardFree==null) {
            return null;
        }

        BoardFreeCommentEntity entity = BoardFreeCommentEntity.builder()
                .boardNo(boardFree.getNo())
                .context(context)
                .date(localDate.toString())
                .build();

        return boardFreeCommentRepository.save(entity).toDto();
    }
}
