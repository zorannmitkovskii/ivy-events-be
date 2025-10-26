package org.ivyinc.eventplanner.storage.config;

import org.ivyinc.eventplanner.storage.service.FileStorageService;
import org.ivyinc.eventplanner.storage.service.LocalStorageService;
import org.ivyinc.eventplanner.storage.service.S3StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${storage.provider:local}")
    private String storageProvider;

    @Bean
    public FileStorageService fileStorageService() {
        return switch (storageProvider.toLowerCase()) {
            case "s3" -> new S3StorageService();
            default -> new LocalStorageService();
        };
    }
}
