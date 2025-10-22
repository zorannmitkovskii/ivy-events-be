-- ===============================================
-- Ivy&Inc Event Planner
-- Flyway Migration: Create "invitations" table
-- ===============================================

CREATE TABLE invitations (
                             id BIGSERIAL PRIMARY KEY,
                             event_id BIGINT NOT NULL,
                             contact_name VARCHAR(255) NOT NULL,
                             contact_email_or_phone VARCHAR(255) NOT NULL,
                             guest_limit INT,
                             status VARCHAR(20) NOT NULL CHECK (status IN ('SENT', 'OPENED', 'RESPONDED')),
                             response_date TIMESTAMP WITHOUT TIME ZONE,
                             message_from_contact TEXT,
                             public_code VARCHAR(50) UNIQUE,
                             created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
                             updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),

                             CONSTRAINT fk_invitation_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

CREATE INDEX idx_invitations_event_id ON invitations(event_id);
CREATE INDEX idx_invitations_public_code ON invitations(public_code);
