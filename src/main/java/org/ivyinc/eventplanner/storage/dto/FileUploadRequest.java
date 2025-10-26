package org.ivyinc.eventplanner.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO representing a file upload request.
 * Can include additional metadata (folder, tags, etc.).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadRequest {

    private MultipartFile file;

    /**
     * Optional folder name where file should be stored.
     * e.g. "events/123/gallery" or "documents/contracts"
     */
    private String folder = "general";

    /**
     * Optional file description or tag for later reference.
     */
    private String description;
}
