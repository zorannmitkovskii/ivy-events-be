package org.ivyinc.eventplanner.storage.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.ApiResponse;
import org.ivyinc.eventplanner.storage.dto.FileUploadResponse;
import org.ivyinc.eventplanner.storage.service.LocalStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FileStorageController {

    private final LocalStorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<FileUploadResponse>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "folder", defaultValue = "general") String folder) {

        String path = storageService.uploadFile(file, folder);
        String publicUrl = storageService.getPublicUrl(path);

        FileUploadResponse response = new FileUploadResponse(publicUrl, file.getOriginalFilename());
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<String>> deleteFile(@RequestParam String path) {
        boolean deleted = storageService.deleteFile(path);
        return ResponseEntity.ok(ApiResponse.ok(deleted ? "Deleted" : "File not found"));
    }
}
