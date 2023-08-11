package com.messenger.lastseen_service.controllers;

import com.messenger.lastseen_service.dto.requests.LastSeenRequest;
import com.messenger.lastseen_service.dto.responses.LastSeenResponse;
import com.messenger.lastseen_service.models.LastSeenModel;
import com.messenger.lastseen_service.services.LastSeenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/last-seen")
public class LastSeenController {

    private final LastSeenService lastSeenService;

    @Autowired
    public LastSeenController(LastSeenService lastSeenService) {
        this.lastSeenService = lastSeenService;
    }

    @GetMapping()
    @Operation(summary = "Получить все записи о последних появлениях пользователей",
            description = "Возвращает список всех записей о последних появлениях пользователей")
    @ApiResponse(responseCode = "200", description = "Успешный запрос",
            content = @Content(schema = @Schema(implementation = List.class)))
    public ResponseEntity<Object> getAllSeen() {
        return ResponseEntity.ok().body(lastSeenService.getAllLastSeen());
    }

    @PostMapping()
    @Operation(summary = "Создать запись о последнем появлении пользователя",
            description = "Создает новую запись о последнем появлении пользователя на основе данных в теле запроса")
    @ApiResponse(responseCode = "200", description = "Успешный запрос",
            content = @Content(schema = @Schema(implementation = LastSeenResponse.class)))
    public ResponseEntity<Object> createLastSeen(@RequestBody LastSeenRequest lastSeenRequest) {
        lastSeenService.createLastSeen(lastSeenRequest.toLastSeenModel());
        return ResponseEntity.ok(lastSeenRequest.toLastSeenModel());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить информацию о последнем появлении пользователя",
            description = "Возвращает информацию о последнем появлении пользователя по его идентификатору")
    @ApiResponse(responseCode = "200", description = "Успешный запрос",
            content = @Content(schema = @Schema(implementation = LastSeenResponse.class)))
    @ApiResponse(responseCode = "400", description = "Пользователь не найден")
    public ResponseEntity<Object> getLastSeenById(@PathVariable("id") int id) {
        try {
            LastSeenModel lastSeenModel = lastSeenService.getLastSeenById(id);
            return ResponseEntity.ok().body(new LastSeenResponse(lastSeenModel.getUserId(), lastSeenModel.getTimestamp()));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
