package com.messenger.lastseen_service.dto.responses;

import com.messenger.lastseen_service.util.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LastSeenResponse {
    private Long userId;
    private LocalDateTime lastSeenDate;
    private UserStatusEnum status;
}
