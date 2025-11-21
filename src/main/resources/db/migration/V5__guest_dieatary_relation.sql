-- Migrate Guest dietary field from JSON Map to relation with Dietary entity
-- Drop old JSON column if exists
ALTER TABLE IF EXISTS guests
    DROP COLUMN IF EXISTS dietary_preferences;

-- Add new foreign key column to dietary
ALTER TABLE IF EXISTS guests
    ADD COLUMN IF NOT EXISTS dieatary_id UUID;

ALTER TABLE IF EXISTS guests
    ADD CONSTRAINT IF NOT EXISTS fk_guests_dieatary
        FOREIGN KEY (dieatary_id) REFERENCES dietary(id);

-- Optional: create index for faster lookups
CREATE INDEX IF NOT EXISTS idx_guests_dieatary_id ON guests(dieatary_id);
