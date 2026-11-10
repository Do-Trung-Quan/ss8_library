package com.example.ss8_library.models.services;

import com.example.ss8_library.models.dto.req.BookCreateDTO;
import com.example.ss8_library.models.dto.req.BookUpdateStockDTO;
import com.example.ss8_library.models.entities.Book;

public interface BookService {
    Book getById(Long id);

    Book add(BookCreateDTO bookCreateDTO);

    Book update(Long id, BookUpdateStockDTO bookUpdateStockDTO);
}
