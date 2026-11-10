package com.example.ss8_library.models.services.impl;

import com.example.ss8_library.exceptions.ResourceNotFoundException;
import com.example.ss8_library.models.dto.req.BookCreateDTO;
import com.example.ss8_library.models.dto.req.BookUpdateStockDTO;
import com.example.ss8_library.models.entities.Book;
import com.example.ss8_library.models.repositories.BookRepository;
import com.example.ss8_library.models.services.BookService;
import com.example.ss8_library.models.services.utils.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UploadService uploadService;

    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
    }

    public Book add(BookCreateDTO bookCreateDTO){
        Book newBook = Book.builder()
                .title(bookCreateDTO.getTitle())
                .author(bookCreateDTO.getAuthor())
                .stock(bookCreateDTO.getStock())
                .coverUrl(uploadService.uploadFile(bookCreateDTO.getCoverImage()))
                .build();
        return bookRepository.save(newBook);
    }

    public Book update(Long id, BookUpdateStockDTO bookUpdateStockDTO){
        Book updatedBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        updatedBook.setStock(bookUpdateStockDTO.getStock());
        return bookRepository.save(updatedBook);
    }
}
