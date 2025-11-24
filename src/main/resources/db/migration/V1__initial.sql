-- Enable pgcrypto for gen_random_uuid()
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- ===================================
-- COUNTRIES (create early because others depend on it)
-- ===================================
CREATE TABLE IF NOT EXISTS countries (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    iso2 CHAR(2) NOT NULL UNIQUE,
    iso3 CHAR(3) NOT NULL UNIQUE,
    country_name VARCHAR(255) NOT NULL,
    flag VARCHAR(20),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
    );

-- ===================================
-- CONTACTS (single source of truth for contact details)
-- ===================================
CREATE TABLE IF NOT EXISTS contacts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
    );

CREATE INDEX IF NOT EXISTS idx_contacts_email ON contacts(email);

-- ===================================
-- EVENT CATEGORIES & EVENT TYPES
-- ===================================
CREATE TABLE IF NOT EXISTS event_categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    icon_url VARCHAR(500),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT uq_event_category_name UNIQUE (name)
    );

CREATE TABLE IF NOT EXISTS event_types (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_category_id UUID,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    icon_url VARCHAR(500),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_event_type_category FOREIGN KEY (event_category_id) REFERENCES event_categories(id),
    CONSTRAINT uq_event_type_name UNIQUE (name)
    );

CREATE INDEX IF NOT EXISTS idx_event_types_category_id ON event_types(event_category_id);

-- ===================================
-- DIETARY
-- ===================================
CREATE TABLE IF NOT EXISTS dietary (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
    );

-- ===================================
-- VENDORS & PACKAGES
-- Use contact_id to store contact details (avoid duplicating name/phone/email)
-- ===================================
CREATE TABLE IF NOT EXISTS vendors (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    vendor_type VARCHAR(100),
    contact_id UUID,
    website VARCHAR(500),
    instagram_url VARCHAR(500),
    service_area VARCHAR(255),
    availability_status VARCHAR(50) DEFAULT 'available',
    contract_url VARCHAR(500),
    rating DECIMAL(3,2),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_vendor_contact FOREIGN KEY (contact_id) REFERENCES contacts(id)
    );

CREATE INDEX IF NOT EXISTS idx_vendors_contact_id ON vendors(contact_id);
CREATE INDEX IF NOT EXISTS idx_vendors_name ON vendors(name);

CREATE TABLE IF NOT EXISTS packages (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10,2),
    price_currency VARCHAR(10) DEFAULT 'EUR',
    video_url VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
    );

-- Junction table for Many-to-Many between vendors and packages
CREATE TABLE IF NOT EXISTS vendor_packages (
    vendor_id UUID NOT NULL,
    package_id UUID NOT NULL,
    PRIMARY KEY (vendor_id, package_id),
    CONSTRAINT fk_vendor_packages_vendor FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE,
    CONSTRAINT fk_vendor_packages_package FOREIGN KEY (package_id) REFERENCES packages(id) ON DELETE CASCADE
    );

CREATE INDEX IF NOT EXISTS idx_vendor_packages_vendor_id ON vendor_packages(vendor_id);
CREATE INDEX IF NOT EXISTS idx_vendor_packages_package_id ON vendor_packages(package_id);



-- ===================================
-- LOCATIONS
-- Keep a single contact_id reference; avoid duplicate address/contact columns
-- ===================================
CREATE TABLE IF NOT EXISTS locations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    type VARCHAR(100),                -- venue, church, hotel, etc.
    address_line VARCHAR(255),
    postal_code VARCHAR(50),
    city VARCHAR(100),
    country_iso3 CHAR(3) NOT NULL,
    latitude DECIMAL(10,8),
    longitude DECIMAL(11,8),
    google_maps_url VARCHAR(500),
    photo_url VARCHAR(500),
    description TEXT,
    capacity INT,
    opening_hours JSON,
    notes TEXT,
    contact_id UUID,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_location_country FOREIGN KEY (country_iso3) REFERENCES countries(iso3),
    CONSTRAINT fk_location_contact FOREIGN KEY (contact_id) REFERENCES contacts(id)
    );

CREATE INDEX IF NOT EXISTS idx_locations_country_iso3 ON locations(country_iso3);
CREATE INDEX IF NOT EXISTS idx_locations_contact_id ON locations(contact_id);
CREATE INDEX IF NOT EXISTS idx_locations_city ON locations(city);

-- Junction table for Many-to-Many between locations and packages
CREATE TABLE IF NOT EXISTS location_packages (
                                                 location_id UUID NOT NULL,
                                                 package_id UUID NOT NULL,
                                                 PRIMARY KEY (location_id, package_id),
    CONSTRAINT fk_location_packages_location FOREIGN KEY (location_id) REFERENCES locations(id) ON DELETE CASCADE,
    CONSTRAINT fk_location_packages_package FOREIGN KEY (package_id) REFERENCES packages(id) ON DELETE CASCADE
    );

CREATE INDEX IF NOT EXISTS idx_location_packages_location_id ON location_packages(location_id);
CREATE INDEX IF NOT EXISTS idx_location_packages_package_id ON location_packages(package_id);
-- ===================================
-- EVENT INFO
-- ===================================
CREATE TABLE IF NOT EXISTS event_info (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    form_id UUID,            -- optional; references form if needed
    note TEXT,
    version INT DEFAULT 1,
    contact_person VARCHAR(255),  -- free text contact if not using contacts
    phone_number VARCHAR(50),
    email VARCHAR(255),
    agenda JSON,
    tags JSON,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
    );

-- ===================================
-- EVENTS
-- Many FKs added: event_type_id -> event_types, event_info_id -> event_info,
-- organizer_id/contact_id -> contacts, vendor_id -> vendors, location_id -> locations
-- ===================================
CREATE TABLE IF NOT EXISTS events (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_type_id UUID,
    event_info_id UUID,
    organizer_id UUID,            -- references contacts (or users if you add users table later)
    name VARCHAR(255) NOT NULL,
    description TEXT,
    agenda_id UUID,
    max_guests INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    location_id UUID,
    vendor_id UUID,
    contact_id UUID,
    notification_type VARCHAR(100),
    unique_url VARCHAR(255) UNIQUE,
    cover_image_url VARCHAR(500),
    timezone VARCHAR(100),
    status VARCHAR(50) DEFAULT 'draft',
    visibility VARCHAR(50) DEFAULT 'private',
    created_by UUID,
    last_updated_by UUID,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_event_type FOREIGN KEY (event_type_id) REFERENCES event_types(id),
    CONSTRAINT fk_event_info FOREIGN KEY (event_info_id) REFERENCES event_info(id),
    CONSTRAINT fk_event_organizer_contact FOREIGN KEY (organizer_id) REFERENCES contacts(id),
    CONSTRAINT fk_event_vendor FOREIGN KEY (vendor_id) REFERENCES vendors(id),
    CONSTRAINT fk_event_contact FOREIGN KEY (contact_id) REFERENCES contacts(id),
    CONSTRAINT fk_event_location FOREIGN KEY (location_id) REFERENCES locations(id)
    );

CREATE INDEX IF NOT EXISTS idx_events_event_type_id ON events(event_type_id);
CREATE INDEX IF NOT EXISTS idx_events_event_info_id ON events(event_info_id);
CREATE INDEX IF NOT EXISTS idx_events_location_id ON events(location_id);
CREATE INDEX IF NOT EXISTS idx_events_vendor_id ON events(vendor_id);
CREATE INDEX IF NOT EXISTS idx_events_organizer_id ON events(organizer_id);

-- ===================================
-- GUESTS
-- Prefer referencing contacts for actual contact details; keep email/phone for quick lookups if desired
-- ===================================
CREATE TABLE IF NOT EXISTS guests (
                                      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone_number VARCHAR(50),
    note TEXT,
    table_number VARCHAR(50),
    dietary_preferences JSON,
    contact_id UUID,
    notification_type VARCHAR(50),
    invite_status VARCHAR(50) DEFAULT 'pending', -- pending, invited, confirmed, declined
    num_of_guests INT DEFAULT 1,
    rsvp_date TIMESTAMP,
    is_vip BOOLEAN DEFAULT FALSE,
    check_in_status BOOLEAN DEFAULT FALSE,
    qr_code VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_guest_event FOREIGN KEY (event_id) REFERENCES events(id),
    CONSTRAINT fk_guest_contact FOREIGN KEY (contact_id) REFERENCES contacts(id)
    );

CREATE INDEX IF NOT EXISTS idx_guests_event_id ON guests(event_id);
CREATE INDEX IF NOT EXISTS idx_guests_contact_id ON guests(contact_id);
CREATE INDEX IF NOT EXISTS idx_guests_email ON guests(email);


-- ===================================
-- FORMS / FIELDS / RESPONSES
-- ===================================
CREATE TABLE IF NOT EXISTS form (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID,
    name VARCHAR(255),
    version INT DEFAULT 1,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_form_event FOREIGN KEY (event_id) REFERENCES events(id)
    );

CREATE INDEX IF NOT EXISTS idx_form_event_id ON form(event_id);

-- Form fields to match JPA entity org.ivyinc.eventplanner.event.model.FormField
CREATE TABLE IF NOT EXISTS fields (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    form_id UUID,
    label VARCHAR(255),
    type VARCHAR(50),
    order_index INT,
    is_required BOOLEAN DEFAULT TRUE,
    placeholder VARCHAR(2048),
    validation_regex VARCHAR(4096),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_field_form FOREIGN KEY (form_id) REFERENCES form(id)
    );

CREATE INDEX IF NOT EXISTS idx_fields_form_id ON fields(form_id);

-- Field options to match JPA entity org.ivyinc.eventplanner.event.model.FieldOption
CREATE TABLE IF NOT EXISTS field_options (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    value VARCHAR(255),
    order_index INT,
    form_field_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_field_option_field FOREIGN KEY (form_field_id) REFERENCES fields(id)
);

-- Responses (FormResponse)
CREATE TABLE IF NOT EXISTS responses (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    field_id UUID,
    guest_id UUID,
    event_id UUID,
    answer TEXT,
    response_status VARCHAR(50) DEFAULT 'submitted', -- partial/submitted
    submitted_by_ip VARCHAR(50),
    submitted_at TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_response_field FOREIGN KEY (field_id) REFERENCES fields(id),
    CONSTRAINT fk_response_guest FOREIGN KEY (guest_id) REFERENCES guests(id),
    CONSTRAINT fk_response_event FOREIGN KEY (event_id) REFERENCES events(id)
    );

CREATE INDEX IF NOT EXISTS idx_responses_field_id ON responses(field_id);

-- ===================================
-- BUDGETS & EXPENSES
-- ===================================
CREATE TABLE IF NOT EXISTS budgets (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID,
    name VARCHAR(255),
    description TEXT,
    amount DECIMAL(10,2),
    remain_amount DECIMAL(10,2),
    currency VARCHAR(10) DEFAULT 'EUR',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_budget_event FOREIGN KEY (event_id) REFERENCES events(id),
    CONSTRAINT chk_budget_amount CHECK (amount IS NULL OR amount >= 0),
    CONSTRAINT chk_budget_remain_amount CHECK (remain_amount IS NULL OR remain_amount >= 0)
    );

CREATE INDEX IF NOT EXISTS idx_budgets_event_id ON budgets(event_id);

CREATE TABLE IF NOT EXISTS expenses (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID,
    budget_id UUID,
    name VARCHAR(255),
    description TEXT,
    amount DECIMAL(10,2),
    due_date DATE,
    payment_status VARCHAR(50) DEFAULT 'unpaid',
    payment_method VARCHAR(50),
    receipt_url VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_expense_event FOREIGN KEY (event_id) REFERENCES events(id),
    CONSTRAINT fk_expense_budget FOREIGN KEY (budget_id) REFERENCES budgets(id)
    );

CREATE INDEX IF NOT EXISTS idx_expenses_event_id ON expenses(event_id);
CREATE INDEX IF NOT EXISTS idx_expenses_budget_id ON expenses(budget_id);

-- ===================================
-- INVITATION TEMPLATES / INVITATIONS / SECTIONS
-- ===================================
CREATE TABLE IF NOT EXISTS invitation_templates (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    template_path VARCHAR(500),
    preview_image VARCHAR(500),
    description TEXT,
    sections JSON,
    theme_color VARCHAR(50),
    font_style VARCHAR(100),
    background_image_url VARCHAR(500),
    language VARCHAR(50) DEFAULT 'en',
    template_version INT DEFAULT 1,
    is_editable BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT chk_template_version CHECK (template_version > 0)
    );

CREATE TABLE IF NOT EXISTS invitations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID,
    template_id UUID,
    form_id UUID,
    custom_sections JSON,
    unique_url VARCHAR(255) UNIQUE,
    sent_at TIMESTAMP,
    view_count INT DEFAULT 0,
    last_viewed_at TIMESTAMP,
    rsvp_token VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_invitation_event FOREIGN KEY (event_id) REFERENCES events(id),
    CONSTRAINT fk_invitation_template FOREIGN KEY (template_id) REFERENCES invitation_templates(id),
    CONSTRAINT fk_invitation_form FOREIGN KEY (form_id) REFERENCES form(id)
    );

CREATE INDEX IF NOT EXISTS idx_invitations_event_id ON invitations(event_id);
CREATE INDEX IF NOT EXISTS idx_invitations_template_id ON invitations(template_id);

CREATE TABLE IF NOT EXISTS sections (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    template_id UUID,
    name VARCHAR(255),
    section_type VARCHAR(50), -- image, text, map, form, gallery
    path VARCHAR(500),
    order_index INT,
    is_required BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_section_template FOREIGN KEY (template_id) REFERENCES invitation_templates(id)
    );

CREATE INDEX IF NOT EXISTS idx_sections_template_id ON sections(template_id);

-- ===================================
-- FEEDBACK
-- ===================================
CREATE TABLE IF NOT EXISTS feedback (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID NOT NULL,
    guest_id UUID,
    vendor_id UUID,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    media_url VARCHAR(255),
    is_public BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_feedback_event FOREIGN KEY (event_id) REFERENCES events (id) ON DELETE CASCADE,
    CONSTRAINT fk_feedback_guest FOREIGN KEY (guest_id) REFERENCES guests (id) ON DELETE SET NULL,
    CONSTRAINT fk_feedback_vendor FOREIGN KEY (vendor_id) REFERENCES vendors (id) ON DELETE SET NULL
    );

CREATE INDEX IF NOT EXISTS idx_feedback_event_id ON feedback(event_id);

-- ===================================
-- SCHEDULE (V4)
-- ===================================
CREATE TABLE IF NOT EXISTS schedules (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID NOT NULL REFERENCES events(id) ON DELETE CASCADE,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP,
    order_index INT,
    description TEXT
    );

CREATE INDEX IF NOT EXISTS idx_schedule_event_id ON schedules(event_id);
CREATE INDEX IF NOT EXISTS idx_schedule_start_time ON schedules(start_time);

-- ===================================
-- Final: Helpful FK indexes (redundant if above index creation already created them via CREATE INDEX)
-- ===================================
-- (Most FK columns already have indexes above. This section is intentionally minimal.)

-- End of migration
