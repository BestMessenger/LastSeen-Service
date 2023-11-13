package com.messenger.lastseen_service.dto.responses;

import com.messenger.lastseen_service.util.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LastSeenResponse {
    private Long userId;
    private LocalDate lastSeenDate;
    private UserStatusEnum status;
}
