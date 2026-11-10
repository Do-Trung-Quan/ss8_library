package com.example.ss8_library.models.dto.res;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String status;
    private String message;
    private LocalDateTime timestamp;
}
