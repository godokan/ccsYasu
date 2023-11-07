package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.ApiUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiUserRepository extends JpaRepository<ApiUserEntity, Integer> {

}