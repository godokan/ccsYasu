package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.BoardNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardNoticeRepository extends JpaRepository<BoardNoticeEntity, Integer> {
    List<BoardNoticeEntity> findAllByOrderByNoDesc();
}
