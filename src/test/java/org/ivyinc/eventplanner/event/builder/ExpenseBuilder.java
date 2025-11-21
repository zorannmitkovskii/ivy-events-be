package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.ExpenseCreateDto;
import org.ivyinc.eventplanner.event.dto.ExpenseResponseDto;
import org.ivyinc.eventplanner.event.dto.ExpenseUpdateDto;
import org.ivyinc.eventplanner.event.model.Budget;
import org.ivyinc.eventplanner.event.model.Event; // unused, will be removed
import org.ivyinc.eventplanner.event.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class ExpenseBuilder implements DtoBuilder<
        Expense,
        ExpenseCreateDto,
        ExpenseUpdateDto,
        ExpenseResponseDto
        > {

    // ==========================================================
    // Shared test data builders (Events, Budgets)
    // ==========================================================

    // Budgets
    protected final BudgetBuilder.WeddingBudget weddingBudgetBuilder = new BudgetBuilder.WeddingBudget();
    protected final BudgetBuilder.TeamBuildingBudget teamBuildingBudgetBuilder = new BudgetBuilder.TeamBuildingBudget();

    protected final Budget weddingBudget = weddingBudgetBuilder.sampleEntity();
    protected final Budget teamBuildingBudget = teamBuildingBudgetBuilder.sampleEntity();

    protected final UUID weddingBudgetId = weddingBudget.getId();
    protected final UUID teamBuildingBudgetId = teamBuildingBudget.getId();


    // ==========================================================
    // Abstract overrides
    // ==========================================================

    @Override
    public abstract Expense sampleEntity();

    @Override
    public abstract ExpenseCreateDto sampleCreateDto();

    @Override
    public abstract ExpenseUpdateDto sampleUpdateDto();

    @Override
    public abstract ExpenseResponseDto sampleCreateResponse(UUID id);

    @Override
    public abstract ExpenseResponseDto sampleUpdateResponse(UUID id);

    @Override
    public Class<ExpenseResponseDto> responseDtoClass() {
        return ExpenseResponseDto.class;
    }


    // ==========================================================
    // 💍 WEDDING EXPENSE
    // ==========================================================
    public static class WeddingExpense extends ExpenseBuilder {

        @Override
        public Expense sampleEntity() {
            return Expense.builder()
                    .budget(weddingBudget)
                    .name("Wedding Photography Deposit")
                    .description("Initial deposit for photographer booking.")
                    .amount(new BigDecimal("500.00"))
                    .dueDate(LocalDateTime.now().plusDays(10))
                    .paymentStatus("PENDING")
                    .paymentMethod("BANK_TRANSFER")
                    .receiptUrl("https://cdn.ivyinc.com/receipts/wedding/photo_deposit.pdf")
                    .build();
        }

        @Override
        public ExpenseCreateDto sampleCreateDto() {
            return new ExpenseCreateDto(
                    weddingBudgetId,
                    "Wedding Photography Deposit",
                    "Initial deposit for photographer booking.",
                    new BigDecimal("500.00"),
                    LocalDate.now().plusDays(10),
                    "PENDING",
                    "BANK_TRANSFER",
                    "https://cdn.ivyinc.com/receipts/wedding/photo_deposit.pdf"
            );
        }

        @Override
        public ExpenseUpdateDto sampleUpdateDto() {
            return new ExpenseUpdateDto(
                    weddingBudgetId,
                    "Wedding Photography Deposit (Updated)",
                    "Updated - paid in full.",
                    new BigDecimal("500.00"),
                    LocalDateTime.now().plusDays(5),
                    "PAID",
                    "BANK_TRANSFER",
                    "https://cdn.ivyinc.com/receipts/wedding/photo_deposit_paid.pdf"
            );
        }

        @Override
        public ExpenseResponseDto sampleCreateResponse(UUID id) {
            return new ExpenseResponseDto(
                    id,
                    weddingBudgetBuilder.sampleCreateResponse(weddingBudgetId),
                    "Wedding Photography Deposit",
                    "Initial deposit for photographer booking.",
                    new BigDecimal("500.00"),
                    LocalDateTime.now().plusDays(10),
                    "PENDING",
                    "BANK_TRANSFER",
                    "https://cdn.ivyinc.com/receipts/wedding/photo_deposit.pdf",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public ExpenseResponseDto sampleUpdateResponse(UUID id) {
            ExpenseUpdateDto updateDto = sampleUpdateDto();
            return new ExpenseResponseDto(
                    id,
                    weddingBudgetBuilder.sampleUpdateResponse(id),
                    updateDto.name(),
                    updateDto.description(),
                    updateDto.amount(),
                    updateDto.dueDate(),
                    updateDto.paymentStatus(),
                    updateDto.paymentMethod(),
                    updateDto.receiptUrl(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }


    // ==========================================================
    // 🏢 TEAM BUILDING EXPENSE
    // ==========================================================
    public static class TeamBuildingExpense extends ExpenseBuilder {

        @Override
        public Expense sampleEntity() {
            return Expense.builder()
                    .budget(teamBuildingBudget)
                    .name("Catering Invoice")
                    .description("Catering service for 50 participants.")
                    .amount(new BigDecimal("1200.00"))
                    .dueDate(LocalDateTime.now().plusDays(7))
                    .paymentStatus("PENDING")
                    .paymentMethod("CREDIT_CARD")
                    .receiptUrl("https://cdn.ivyinc.com/receipts/team/catering_invoice.pdf")
                    .build();
        }

        @Override
        public ExpenseCreateDto sampleCreateDto() {
            return new ExpenseCreateDto(
                    weddingBudgetId,
                    "Catering Invoice",
                    "Catering service for 50 participants.",
                    new BigDecimal("1200.00"),
                    LocalDate.now().plusDays(7),
                    "PENDING",
                    "CREDIT_CARD",
                    "https://cdn.ivyinc.com/receipts/team/catering_invoice.pdf"
            );
        }

        @Override
        public ExpenseUpdateDto sampleUpdateDto() {
            return new ExpenseUpdateDto(
                    teamBuildingBudgetId,
                    "Catering Invoice (Updated)",
                    "Updated - invoice partially paid.",
                    new BigDecimal("1200.00"),
                    LocalDateTime.now().plusDays(3),
                    "PARTIALLY_PAID",
                    "CREDIT_CARD",
                    "https://cdn.ivyinc.com/receipts/team/catering_invoice_updated.pdf"
            );
        }

        @Override
        public ExpenseResponseDto sampleCreateResponse(UUID id) {
            return new ExpenseResponseDto(
                    id,
                    teamBuildingBudgetBuilder.sampleCreateResponse(weddingBudgetId),
                    "Catering Invoice",
                    "Catering service for 50 participants.",
                    new BigDecimal("1200.00"),
                    LocalDateTime.now(),
                    "PENDING",
                    "CREDIT_CARD",
                    "https://cdn.ivyinc.com/receipts/team/catering_invoice.pdf",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public ExpenseResponseDto sampleUpdateResponse(UUID id) {
            ExpenseUpdateDto updateDto = sampleUpdateDto();
            return new ExpenseResponseDto(
                    id,
                    teamBuildingBudgetBuilder.sampleCreateResponse(weddingBudgetId),
                    updateDto.name(),
                    updateDto.description(),
                    updateDto.amount(),
                    updateDto.dueDate(),
                    updateDto.paymentStatus(),
                    updateDto.paymentMethod(),
                    updateDto.receiptUrl(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
}
