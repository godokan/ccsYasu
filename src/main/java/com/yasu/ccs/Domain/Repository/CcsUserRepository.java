package com.yasu.ccs.Domain.Repository;

import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CcsUserRepository extends JpaRepository<CcsUserEntity, Integer> {
}