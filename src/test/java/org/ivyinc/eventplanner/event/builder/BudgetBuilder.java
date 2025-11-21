package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.BudgetCreateDto;
import org.ivyinc.eventplanner.event.dto.BudgetResponseDto;
import org.ivyinc.eventplanner.event.dto.BudgetUpdateDto;
import org.ivyinc.eventplanner.event.model.Budget;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BudgetBuilder implements DtoBuilder<Budget, BudgetCreateDto, BudgetUpdateDto, BudgetResponseDto> {

    @Override
    public abstract Budget sampleEntity();

    @Override
    public abstract BudgetCreateDto sampleCreateDto();

    @Override
    public abstract BudgetUpdateDto sampleUpdateDto();

    @Override
    public BudgetResponseDto sampleCreateResponse(UUID id) {
        Budget entity = sampleEntity();
        return new BudgetResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null, // eventId
                entity.getName(),
                entity.getDescription(),
                entity.getAmount(),
                entity.getRemainAmount()
        );
    }

    @Override
    public BudgetResponseDto sampleUpdateResponse(UUID id) {
        BudgetUpdateDto dto = sampleUpdateDto();
        return new BudgetResponseDto(
                id,
                LocalDateTime.now(),
                LocalDateTime.now(),
                dto.eventId(),
                dto.name(),
                dto.description(),
                dto.amount(),
                dto.remainAmount()
        );
    }

    @Override
    public Class<BudgetResponseDto> responseDtoClass() {
        return BudgetResponseDto.class;
    }

    // ==================== Static subclasses ====================

    public static class WeddingBudget extends BudgetBuilder {

        @Override
        public Budget sampleEntity() {
            return Budget.builder()
                    .name("Wedding Budget")
                    .description("Estimated budget for a wedding event")
                    .amount(new BigDecimal("5000.00"))
                    .remainAmount(new BigDecimal("2500.00"))
                    .currency("EUR")
                    .build();
        }

        @Override
        public BudgetCreateDto sampleCreateDto() {
            return new BudgetCreateDto(
                    "Wedding Budget",
                    "Estimated budget for a wedding event",
                    new BigDecimal("5000.00")
            );
        }

        @Override
        public BudgetUpdateDto sampleUpdateDto() {
            return new BudgetUpdateDto(
                    UUID.randomUUID().toString(),
                    "Updated Wedding Budget",
                    "Updated budget for a wedding event",
                    new BigDecimal("6000.00"),
                    new BigDecimal("3500.00")
            );
        }
    }

    public static class TeamBuildingBudget extends BudgetBuilder {

        @Override
        public Budget sampleEntity() {
            return Budget.builder()
                    .name("Team Building Budget")
                    .description("Estimated budget for team building activities")
                    .amount(new BigDecimal("2000.00"))
                    .remainAmount(new BigDecimal("1200.00"))
                    .currency("EUR")
                    .build();
        }

        @Override
        public BudgetCreateDto sampleCreateDto() {
            return new BudgetCreateDto(
                    "Team Building Budget",
                    "Estimated budget for team building activities",
                    new BigDecimal("2000.00")
            );
        }

        @Override
        public BudgetUpdateDto sampleUpdateDto() {
            return new BudgetUpdateDto(
                    UUID.randomUUID().toString(),
                    "Updated Team Building Budget",
                    "Updated budget for team building activities",
                    new BigDecimal("2500.00"),
                    new BigDecimal("1500.00")
            );
        }
    }
}

