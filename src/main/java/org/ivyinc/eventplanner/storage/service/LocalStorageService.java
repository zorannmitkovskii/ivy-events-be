package org.ivyinc.eventplanner.storage.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;

@Slf4j
@Service
public class LocalStorageService implements FileStorageService {

    @Value("${storage.local.path:uploads}")
    private String localPath;

    @Override
    public String uploadFile(MultipartFile file, String folder) {
        try {
            Path uploadDir = Paths.get(localPath, folder);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            Path targetPath = uploadDir.resolve(Objects.requireNonNull(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            log.info("File uploaded locally: {}", targetPath.toAbsolutePath());
            return targetPath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file locally", e);
        }
    }

    @Override
    public boolean deleteFile(String filePath) {
        try {
            return Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            log.error("Failed to delete local file: {}", filePath);
            return false;
        }
    }

    @Override
    public String getPublicUrl(String filePath) {
        // For local dev — return relative URL
        return "/uploads/" + Paths.get(filePath).getFileName();
    }
}
