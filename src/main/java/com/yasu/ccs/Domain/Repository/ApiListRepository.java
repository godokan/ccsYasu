package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.ApiListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiListRepository extends JpaRepository<ApiListEntity, Integer> {
    public ApiListEntity findByName(String name);
    public ApiListEntity findById(String id);
}