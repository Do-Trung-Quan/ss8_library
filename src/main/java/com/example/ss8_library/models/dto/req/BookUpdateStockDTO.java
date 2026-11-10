package com.example.ss8_library.models.dto.req;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateStockDTO {
    @Min(value = 0, message = "Stock must be a non negative integer.")
    private int stock;
}
