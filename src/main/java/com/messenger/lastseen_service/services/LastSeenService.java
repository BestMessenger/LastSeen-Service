package com.messenger.lastseen_service.services;

import com.messenger.lastseen_service.models.LastSeenModel;
import com.messenger.lastseen_service.repositories.LastSeenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LastSeenService {

    private final LastSeenRepository lastSeenRepository;

    @Autowired
    public LastSeenService(LastSeenRepository lastSeenRepository) {
        this.lastSeenRepository = lastSeenRepository;
    }

    public List<LastSeenModel> getAllLastSeen() {
        return (List<LastSeenModel>) lastSeenRepository.findAll();
    }

    public void deleteLastSeen (int id) {
        lastSeenRepository.deleteById(id);
    }

    public void createLastSeen (LastSeenModel lastSeenModel) {
        lastSeenRepository.save(lastSeenModel);
    }

    @Transactional
    public LastSeenModel getLastSeenById (int id) {
        return lastSeenRepository.findById(id).orElseThrow(() -> new NoSuchElementException("LastSeenModel not found for id: " + id));
    }
}
