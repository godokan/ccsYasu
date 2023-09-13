package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFreeCommentRepository extends JpaRepository<BoardFreeCommentEntity, Integer> {

}
