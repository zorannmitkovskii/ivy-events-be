package org.ivyinc.eventplanner.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileUploadResponse {
    private String url;
    private String filename;
}
