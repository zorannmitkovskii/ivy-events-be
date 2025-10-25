package org.ivyinc.eventplanner.event.repository;

import org.ivyinc.eventplanner.common.BaseRepository;
import org.ivyinc.eventplanner.event.model.Expense;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends BaseRepository<Expense> {
}
