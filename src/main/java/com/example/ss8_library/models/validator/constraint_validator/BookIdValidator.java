package com.example.ss8_library.models.validator.constraint_validator;

import com.example.ss8_library.models.repositories.BookRepository;
import com.example.ss8_library.models.validator.annotation.ExistingBookId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookIdValidator implements ConstraintValidator<ExistingBookId, Long> {

    private final BookRepository bookRepository;

    @Override
    public boolean isValid(Long bookId, ConstraintValidatorContext context) {
        if (bookId == null) {
            return false;
        }
        return bookRepository.existsById(bookId);
    }
}

