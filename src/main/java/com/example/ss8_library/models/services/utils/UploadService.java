package com.example.ss8_library.models.services.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadService {
    // Thư mục lưu trữ file (tương đối theo thư mục gốc của project)
    private static final String UPLOAD_DIR = "uploads";

    public String uploadFile(MultipartFile file) {
        // 1. Kiểm tra nếu file không có dữ liệu
        if (file == null || file.isEmpty()) {
            return null; // hoặc trả về 1 ảnh mặc định: "default-book.png"
        }
        try {
            // 2. Định nghĩa thư mục lưu trữ và tự động tạo nếu chưa có
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 3. Tạo tên file duy nhất bằng UUID để tránh trùng tên
            String originalFilename = file.getOriginalFilename();
            String uniqueFilename = UUID.randomUUID().toString() + "_" + originalFilename;

            // 4. Đường dẫn đầy đủ của file cần lưu
            Path destinationFilePath = uploadPath.resolve(uniqueFilename);

            // 5. Lưu file vào ổ đĩa (thay thế nếu đã tồn tại)
            Files.copy(file.getInputStream(), destinationFilePath, StandardCopyOption.REPLACE_EXISTING);

            // 6. Trả về đường dẫn để lưu vào database (ví dụ: uploads/xxx_name.jpg)
            return UPLOAD_DIR + "/" + uniqueFilename;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi lưu trữ file: " + e.getMessage(), e);
        }
    }
}
