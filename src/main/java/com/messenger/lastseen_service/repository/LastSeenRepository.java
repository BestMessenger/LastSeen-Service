package com.messenger.lastseen_service.repository;

import com.messenger.lastseen_service.model.LastSeenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastSeenRepository extends JpaRepository<LastSeenModel, Long> {
    boolean existsByUserId(Long userId);
}
