    package com.messenger.lastseen_service.util;

    import feign.FeignException;
    import lombok.AllArgsConstructor;
    import com.messenger.lastseen_service.openfeign_client.UserProfileServiceClient;
    import org.springframework.stereotype.Component;

    @AllArgsConstructor
    @Component
    public class UserChecker {

        private final UserProfileServiceClient userProfileServiceClient;

        public boolean isExistUserInProfileService(Long userId) {
            try {
                userProfileServiceClient.getUserById(userId);
            } catch (FeignException.NotFound e) {
                return false;
            }
            return true;
        }
    }
