package com.messenger.lastseen_service.controller;

import com.messenger.lastseen_service.dto.responses.LastSeenResponse;
import com.messenger.lastseen_service.services.service_interface.LastSeenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/last-seen")
@AllArgsConstructor
public class LastSeenController {

    private final LastSeenService lastSeenService;

    @PostMapping("/notify-online/{userId}")
    @Operation(
            summary = "Notify user online",
            description = "Notify the system that the user with the given ID is online."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User online notification successful"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<LastSeenResponse> notifyUserOnline(@Parameter(description = "User ID", required = true) @PathVariable Long userId) {
        LastSeenResponse response = lastSeenService.notifyUserOnline(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/notify-offline/{userId}")
    @Operation(
            summary = "Notify user offline",
            description = "Notify the system that the user with the given ID is offline."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User offline notification successful"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<LastSeenResponse> notifyUserOffline(@Parameter(description = "User ID", required = true) @PathVariable Long userId) {
        LastSeenResponse response = lastSeenService.notifyUserOffline(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
//com.messenger.lastseen_service.controller.LastSeenController
//        com.messenger.lastseen_service.controllers.LastSeenController

