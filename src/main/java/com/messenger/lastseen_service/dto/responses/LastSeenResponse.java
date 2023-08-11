package com.messenger.lastseen_service.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LastSeenResponse {

    private int userId;

    private Date timestamp;
}
