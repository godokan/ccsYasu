package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardFreeRepository extends JpaRepository<BoardFreeEntity, Integer> {
    List<BoardFreeEntity> findAllByOrderByNoDesc();
}
