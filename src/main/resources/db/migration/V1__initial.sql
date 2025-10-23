-- Enable UUID generation in PostgreSQL (remove if using MySQL)
-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ===============================
-- 1️⃣ Event Category & Type
-- ===============================
CREATE TABLE event_categories (
                                  id UUID PRIMARY KEY,
                                  name VARCHAR(255) NOT NULL,
                                  description TEXT,
                                  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE event_types (
                             id UUID PRIMARY KEY,
                             event_category_id UUID,
                             name VARCHAR(255) NOT NULL,
                             description TEXT,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             CONSTRAINT fk_event_type_category FOREIGN KEY (event_category_id) REFERENCES event_categories(id)
);

-- ===============================
-- 2️⃣ Event Info & Event
-- ===============================
CREATE TABLE event_info (
                            id UUID PRIMARY KEY,
                            form_id UUID,
                            note TEXT,
                            version INT DEFAULT 1,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE events (
                        id UUID PRIMARY KEY,
                        event_type_id UUID,
                        event_info_id UUID,
                        organizer_id UUID,
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
                        package_ids JSON,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        CONSTRAINT fk_event_type FOREIGN KEY (event_type_id) REFERENCES event_types(id),
                        CONSTRAINT fk_event_info FOREIGN KEY (event_info_id) REFERENCES event_info(id)
);

-- ===============================
-- 3️⃣ Dietary
-- ===============================
CREATE TABLE dietary (
                         id UUID PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ===============================
-- 4️⃣ Guests, Forms, Fields, Responses
-- ===============================
CREATE TABLE guests (
                        id UUID PRIMARY KEY,
                        event_id UUID NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        note TEXT,
                        table_number VARCHAR(50),
                        dietary_preferences JSON,
                        contact_id UUID,
                        notification_type VARCHAR(50),
                        check_in_status BOOLEAN DEFAULT FALSE,
                        qr_code VARCHAR(255),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        CONSTRAINT fk_guest_event FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE forms (
                       id UUID PRIMARY KEY,
                       event_id UUID,
                       name VARCHAR(255),
                       description TEXT,
                       version INT DEFAULT 1,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       CONSTRAINT fk_form_event FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE fields (
                        id UUID PRIMARY KEY,
                        form_id UUID,
                        question VARCHAR(255),
                        field_type VARCHAR(50),
                        options JSON,
                        is_required BOOLEAN DEFAULT TRUE,
                        field_order INT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_field_form FOREIGN KEY (form_id) REFERENCES forms(id)
);

CREATE TABLE responses (
                           id UUID PRIMARY KEY,
                           field_id UUID,
                           guest_id UUID,
                           event_id UUID,
                           answer TEXT,
                           submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT fk_response_field FOREIGN KEY (field_id) REFERENCES fields(id),
                           CONSTRAINT fk_response_guest FOREIGN KEY (guest_id) REFERENCES guests(id),
                           CONSTRAINT fk_response_event FOREIGN KEY (event_id) REFERENCES events(id)
);

-- ===============================
-- 5️⃣ Locations
-- ===============================
CREATE TABLE locations (
                           id UUID PRIMARY KEY,
                           name VARCHAR(255),
                           address_line VARCHAR(255),
                           city VARCHAR(100),
                           country VARCHAR(100),
                           latitude DECIMAL(10,8),
                           longitude DECIMAL(11,8),
                           google_maps_url VARCHAR(500),
                           description TEXT,
                           capacity INT,
                           notes TEXT,
                           contact_id UUID,
                           is_active BOOLEAN DEFAULT TRUE,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ===============================
-- 6️⃣ Vendors
-- ===============================
CREATE TABLE vendors (
                         id UUID PRIMARY KEY,
                         name VARCHAR(255),
                         vendor_type VARCHAR(100),
                         contact_id UUID,
                         website VARCHAR(500),
                         instagram_url VARCHAR(500),
                         rating DECIMAL(3,2),
                         is_active BOOLEAN DEFAULT TRUE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ===============================
-- 7️⃣ Packages
-- ===============================
CREATE TABLE packages (
                          id UUID PRIMARY KEY,
                          name VARCHAR(255),
                          description TEXT,
                          vendor_id UUID,
                          video_url VARCHAR(500),
                          price DECIMAL(10,2),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_package_vendor FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);

-- ===============================
-- 8️⃣ Music
-- ===============================
CREATE TABLE music (
                       id UUID PRIMARY KEY,
                       event_id UUID,
                       name VARCHAR(255),
                       description TEXT,
                       video_url VARCHAR(500),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       CONSTRAINT fk_music_event FOREIGN KEY (event_id) REFERENCES events(id)
);

-- ===============================
-- 9️⃣ Budget & Expenses
-- ===============================
CREATE TABLE budgets (
                         id UUID PRIMARY KEY,
                         event_id UUID,
                         name VARCHAR(255),
                         description TEXT,
                         amount DECIMAL(10,2),
                         remain_amount DECIMAL(10,2),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_budget_event FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE expenses (
                          id UUID PRIMARY KEY,
                          event_id UUID,
                          budget_id UUID,
                          name VARCHAR(255),
                          description TEXT,
                          amount DECIMAL(10,2),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_expense_event FOREIGN KEY (event_id) REFERENCES events(id),
                          CONSTRAINT fk_expense_budget FOREIGN KEY (budget_id) REFERENCES budgets(id)
);

-- ===============================
-- 🔟 Invitation Templates, Invitations & Sections
-- ===============================
CREATE TABLE invitation_templates (
                                      id UUID PRIMARY KEY,
                                      name VARCHAR(255),
                                      template_path VARCHAR(500),
                                      preview_image VARCHAR(500),
                                      description TEXT,
                                      sections JSON, -- predefined sections like "story", "agenda", "location", etc.
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE invitations (
                             id UUID PRIMARY KEY,
                             event_id UUID,
                             template_id UUID,
                             form_id UUID,
                             custom_sections JSON,
                             unique_url VARCHAR(255) UNIQUE,
                             is_active BOOLEAN DEFAULT TRUE,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             CONSTRAINT fk_invitation_event FOREIGN KEY (event_id) REFERENCES events(id),
                             CONSTRAINT fk_invitation_template FOREIGN KEY (template_id) REFERENCES invitation_templates(id)
);

CREATE TABLE sections (
                          id UUID PRIMARY KEY,
                          template_id UUID,
                          name VARCHAR(255),
                          path VARCHAR(500),
                          order_index INT,
                          is_required BOOLEAN DEFAULT TRUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_section_template FOREIGN KEY (template_id) REFERENCES invitation_templates(id)
);
