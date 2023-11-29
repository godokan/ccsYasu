package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Optional;

public interface BoardFreeCommentRepository extends JpaRepository<BoardFreeCommentEntity, Integer> {
    Optional<List<BoardFreeCommentEntity>> findByBoardNo(Integer boardId);
}
