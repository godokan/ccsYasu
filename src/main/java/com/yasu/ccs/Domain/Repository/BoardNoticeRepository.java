package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.BoardNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardNoticeRepository extends JpaRepository<BoardNoticeEntity, Integer> {

}
