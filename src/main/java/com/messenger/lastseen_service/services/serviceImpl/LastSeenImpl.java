package com.messenger.lastseen_service.services.serviceImpl;

import com.messenger.lastseen_service.dto.responses.LastSeenResponse;
import com.messenger.lastseen_service.exception.NoEntityFoundException;
import com.messenger.lastseen_service.model.LastSeenModel;
import com.messenger.lastseen_service.repository.LastSeenRepository;
import com.messenger.lastseen_service.services.service_interface.LastSeenService;
import com.messenger.lastseen_service.util.UserChecker;
import com.messenger.lastseen_service.util.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class LastSeenImpl implements LastSeenService {
    private final UserChecker userChecker;
    private final LastSeenRepository lastSeenRepository;

    @Override
    public LastSeenResponse notifyUserOnline(Long userId) {
        if (!userChecker.isExistUserInProfileService(userId)) {
            throw new NoEntityFoundException("User with id: " + userId + " doesn't exist");
        } else {
            lastSeenRepository.save(new LastSeenModel(userId, null, UserStatusEnum.ONLINE));
        }
        return new LastSeenResponse(userId, null, UserStatusEnum.ONLINE);
    }

    @Override
    public LastSeenResponse notifyUserOffline(Long userId) {
        if (!userChecker.isExistUserInProfileService(userId)) {
            throw new NoEntityFoundException("User with id: " + userId + " doesn't exist");
        } else {
            lastSeenRepository.save(new LastSeenModel(userId, null, UserStatusEnum.OFFLINE));
        }
        return new LastSeenResponse(userId, null, UserStatusEnum.OFFLINE);
    }
}
