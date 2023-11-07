package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.ApiUserListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiUserListRepository extends JpaRepository<ApiUserListEntity, Integer> {
}
