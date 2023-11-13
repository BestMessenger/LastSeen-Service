package com.messenger.lastseen_service.model;

import com.messenger.lastseen_service.util.UserStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name = "LastSeen")
public class LastSeenModel {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "last_seen_date", nullable = false)
    private LocalDate lastSeenDate;

    @Column(name = "status", nullable = false)
    private UserStatusEnum status;

}
