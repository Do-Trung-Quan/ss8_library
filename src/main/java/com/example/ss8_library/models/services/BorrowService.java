package com.example.ss8_library.models.services;

import com.example.ss8_library.models.dto.req.BorrowCreateDTO;
import com.example.ss8_library.models.entities.Borrow;

public interface BorrowService {
    public Borrow add(BorrowCreateDTO borrowCreateDTO);
}
