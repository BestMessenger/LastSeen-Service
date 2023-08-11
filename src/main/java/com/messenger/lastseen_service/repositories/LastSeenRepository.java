package com.messenger.lastseen_service.repositories;

import com.messenger.lastseen_service.models.LastSeenModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastSeenRepository extends CrudRepository<LastSeenModel, Integer> {
}
