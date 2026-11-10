package com.example.ss8_library.models.dto.req;

import com.example.ss8_library.models.validator.annotation.ExistingBookId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowCreateDTO {
    @NotBlank(message = "username must not be empty")
    private String username;

    @NotNull(message = "bookId must not be null")
    @ExistingBookId
    private Long bookId;
}
