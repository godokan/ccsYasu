package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface BoardFreeCommentRepository extends JpaRepository<BoardFreeCommentEntity, Integer> {
    @Query(value = "SELECT * FROM board_free_comment" +
            "WHERE board_no = :board_no",
            nativeQuery = true)
    List<BoardFreeCommentEntity> findByFreeBoardId(Integer boardId);
}
