package com.messenger.lastseen_service.dto.requests;

import com.messenger.lastseen_service.models.LastSeenModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LastSeenRequest {

    private int userId;

    public LastSeenModel toLastSeenModel () {
        return new LastSeenModel(userId, new Date());
    }
}
