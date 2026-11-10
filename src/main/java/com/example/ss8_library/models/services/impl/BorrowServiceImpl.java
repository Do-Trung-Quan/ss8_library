package com.example.ss8_library.models.services.impl;

import com.example.ss8_library.models.dto.req.BorrowCreateDTO;
import com.example.ss8_library.models.entities.Borrow;
import com.example.ss8_library.models.repositories.BorrowRepository;
import com.example.ss8_library.models.services.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;

    public Borrow add(BorrowCreateDTO borrowCreateDTO) {
        Borrow borrow = Borrow.builder()
                .username(borrowCreateDTO.getUsername())
                .bookId(borrowCreateDTO.getBookId())
                .build();
        return borrowRepository.save(borrow);
    }
}
