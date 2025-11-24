-- Drop old JSON column if exists
ALTER TABLE guests
DROP COLUMN IF EXISTS dietary_preferences;

-- Add new foreign key column
ALTER TABLE guests
    ADD COLUMN IF NOT EXISTS dietary_id UUID;

-- Add FK constraint if it doesn't already exist (PostgreSQL doesn't support IF NOT EXISTS here)
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM information_schema.table_constraints tc
        WHERE tc.constraint_type = 'FOREIGN KEY'
          AND tc.table_name = 'guests'
          AND tc.constraint_name = 'fk_guests_dietary'
    ) THEN
        ALTER TABLE guests
            ADD CONSTRAINT fk_guests_dietary
            FOREIGN KEY (dietary_id) REFERENCES dietary(id);
    END IF;
END $$;

-- Optional index
CREATE INDEX IF NOT EXISTS idx_guests_dietary_id ON guests(dietary_id);
