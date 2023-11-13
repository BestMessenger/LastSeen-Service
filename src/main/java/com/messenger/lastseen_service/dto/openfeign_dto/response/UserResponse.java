package com.messenger.lastseen_service.dto.openfeign_dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long userid;
    private String username;
    private String password;
    private String contact;
    private String email;
    private String name;
    private String last_name;
}
