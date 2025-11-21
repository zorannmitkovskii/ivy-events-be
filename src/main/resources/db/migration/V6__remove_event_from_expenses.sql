-- Remove event_id from expenses as per requirement to decouple Expense from Event

-- Drop foreign key constraint if exists
DO $$
BEGIN
    IF EXISTS (
        SELECT 1 FROM information_schema.table_constraints tc
        WHERE tc.constraint_type = 'FOREIGN KEY'
          AND tc.table_name = 'expenses'
          AND tc.constraint_name = 'fk_expense_event'
    ) THEN
        ALTER TABLE IF EXISTS expenses DROP CONSTRAINT fk_expense_event;
    END IF;
END $$;

-- Drop index on event_id if exists
DROP INDEX IF EXISTS idx_expenses_event_id;

-- Drop the column itself if exists
ALTER TABLE IF EXISTS expenses
    DROP COLUMN IF EXISTS event_id;
