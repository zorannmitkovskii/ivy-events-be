-- ===============================================
-- Ivy&Inc Event Planner
-- Flyway Migration: Create "events" table
-- NOTE: Removed FK to users(id) because users table is not managed by this service.
-- ===============================================

CREATE TABLE events (
                        id BIGSERIAL PRIMARY KEY,
                        owner_id UUID NOT NULL,
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        type VARCHAR(20) NOT NULL CHECK (type IN ('WEDDING', 'BIRTHDAY', 'CORPORATE', 'OTHER')),
                        date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                        venue VARCHAR(255),
                        cover_image TEXT,
                        estimated_budget DECIMAL(12,2),
                        theme_color VARCHAR(20),
                        rsvp_deadline TIMESTAMP WITHOUT TIME ZONE,
                        is_photo_upload_enabled BOOLEAN DEFAULT FALSE,
                        is_public BOOLEAN DEFAULT FALSE,
                        public_code VARCHAR(50) UNIQUE,

                        created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
                        updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);

-- Indexes for common query fields
CREATE INDEX idx_events_owner_id ON events(owner_id);
CREATE INDEX idx_events_public_code ON events(public_code);
CREATE INDEX idx_events_date_time ON events(date_time);
