package org.ivyinc.eventplanner.common.builder;

import java.util.UUID;

public interface DtoBuilder<ENTITY, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO> {
    ENTITY sampleEntity();
    CREATE_DTO sampleCreateDto();
    UPDATE_DTO sampleUpdateDto();
    RESPONSE_DTO sampleCreateResponse(UUID id);
    RESPONSE_DTO sampleUpdateResponse(UUID id);
    Class<RESPONSE_DTO> responseDtoClass(); // <--- new method
}

