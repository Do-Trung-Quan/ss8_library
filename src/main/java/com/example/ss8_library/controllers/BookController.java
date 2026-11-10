package com.example.ss8_library.controllers;

import com.example.ss8_library.models.dto.req.BookCreateDTO;
import com.example.ss8_library.models.dto.req.BookUpdateStockDTO;
import com.example.ss8_library.models.entities.Book;
import com.example.ss8_library.models.services.BookService;
import com.example.ss8_library.models.services.impl.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Book> add(@Valid @ModelAttribute BookCreateDTO bookCreateDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.add(bookCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(
            @PathVariable Long id,
            @Valid @RequestBody BookUpdateStockDTO bookUpdateStockDTO){
        return ResponseEntity.ok(bookService.update(id, bookUpdateStockDTO));
    }

}
