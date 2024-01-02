package com.messenger.lastseen_service.services.service_interface;

import com.messenger.lastseen_service.dto.responses.LastSeenResponse;

public interface LastSeenService {
    LastSeenResponse notifyUserOnline(Long userId);
    LastSeenResponse notifyUserOffline(Long userId);

}
