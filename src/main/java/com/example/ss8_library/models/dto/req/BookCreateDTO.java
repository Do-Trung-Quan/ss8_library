package com.example.ss8_library.models.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDTO {
    @NotBlank(message = "Tên sách không được để trống")
    private String title;
    @NotBlank(message = "Tên tác giả không được để trống")
    private String author;
    private int stock;
    private MultipartFile coverImage;
}
