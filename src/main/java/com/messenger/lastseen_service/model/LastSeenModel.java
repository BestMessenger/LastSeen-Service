package com.messenger.lastseen_service.model;

import com.messenger.lastseen_service.util.UserStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lastseen")
public class LastSeenModel {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "last_seen_date")
    private LocalDateTime lastSeenDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatusEnum status;
}
