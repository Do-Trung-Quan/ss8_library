package com.example.ss8_library.controllers;

import com.example.ss8_library.models.dto.req.BorrowCreateDTO;
import com.example.ss8_library.models.entities.Borrow;
import com.example.ss8_library.models.services.BorrowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrows")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;

    @PostMapping()
    public ResponseEntity<Borrow> add(@Valid @RequestBody BorrowCreateDTO borrowCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowService.add(borrowCreateDTO));
    }
}
