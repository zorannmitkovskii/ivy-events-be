package org.ivyinc.eventplanner.storage.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String uploadFile(MultipartFile file, String folder);

    boolean deleteFile(String filePath);

    String getPublicUrl(String filePath);
}
