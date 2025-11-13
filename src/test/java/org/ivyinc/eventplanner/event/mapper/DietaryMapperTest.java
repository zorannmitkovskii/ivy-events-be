package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.event.builder.DietaryBuilder;
import org.ivyinc.eventplanner.event.dto.DietaryCreateDto;
import org.ivyinc.eventplanner.event.dto.DietaryResponseDto;
import org.ivyinc.eventplanner.event.dto.DietaryUpdateDto;
import org.ivyinc.eventplanner.event.model.Dietary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.ivyinc.eventplanner.event.builder.DietaryBuilder.*;

@SpringBootTest
@ActiveProfiles("test")
public class DietaryMapperTest {

    @Autowired
    private DietaryMapper mapper;

    private DietaryBuilder dietaryBuilder;
    @Test
    @DisplayName("toEntity should map nested contact object")
    void toEntity_shouldMapNestedContact() {
        DietaryCreateDto createDto = dietaryBuilder.sampleCreateDto();
        Dietary entity = mapper.toEntity(createDto);
        assertSoftly(softly ->{
            softly.assertThat(entity).isNotNull();
            softly.assertThat(entity.getName()).isEqualTo(createDto.name());
            softly.assertThat(entity.getDescription()).isEqualTo(createDto.description());
        });
    }

    @Test
    @DisplayName("toResponse should map entity contact into ContactResponseDto")
    void toResponse_shouldBuildNestedContact() {
        Dietary entity = dietaryBuilder.sampleDietary();
        entity.setId(UUID.randomUUID());
        DietaryResponseDto response = mapper.toResponse(entity);
        assertSoftly(softly ->{
            softly.assertThat(response).isNotNull();
            softly.assertThat(response.id()).isEqualTo(entity.getId());
            softly.assertThat(response.name()).isEqualTo(entity.getName());
            softly.assertThat(response.description()).isEqualTo(entity.getDescription());
        });
    }

    @Test
    @DisplayName("updateEntity should update contact via AfterMapping and ignore nulls")
    void updateEntity_shouldUpdateContactAndIgnoreNulls() {
        Dietary entity = dietaryBuilder.sampleDietary();
        DietaryUpdateDto updateDto = dietaryBuilder.sampleUpdateDto();
        mapper.updateEntity(entity, updateDto);
        assertSoftly(softly ->{
            softly.assertThat(entity.getName()).isEqualTo(updateDto.name());
            softly.assertThat(entity.getDescription()).isEqualTo(updateDto.description());
        });

    }
}
