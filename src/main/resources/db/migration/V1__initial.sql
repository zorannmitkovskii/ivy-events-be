-- Enable UUID extension in PostgreSQL (remove if using MySQL)
-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ===================================
-- 1️⃣ Event Category & Event Type
-- ===================================
CREATE TABLE event_categories (
                                  id CHAR(36) PRIMARY KEY,
                                  name VARCHAR(255) NOT NULL,
                                  description TEXT,
                                  icon_url VARCHAR(500),
                                  is_active BOOLEAN DEFAULT TRUE,
                                  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE event_types (
                             id CHAR(36) PRIMARY KEY,
                             event_category_id CHAR(36),
                             name VARCHAR(255) NOT NULL,
                             description TEXT,
                             icon_url VARCHAR(500),
                             is_active BOOLEAN DEFAULT TRUE,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             CONSTRAINT fk_event_type_category FOREIGN KEY (event_category_id) REFERENCES event_categories(id)
);

-- ===================================
-- 2️⃣ Event Info & Event
-- ===================================
CREATE TABLE event_info (
                            id CHAR(36) PRIMARY KEY,
                            form_id CHAR(36),
                            note TEXT,
                            version INT DEFAULT 1,
                            contact_person VARCHAR(255),
                            phone_number VARCHAR(50),
                            email VARCHAR(255),
                            agenda JSON,
                            tags JSON,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE events (
                        id CHAR(36) PRIMARY KEY,
                        event_type_id CHAR(36),
                        event_info_id CHAR(36),
                        organizer_id CHAR(36),
                        name VARCHAR(255) NOT NULL,
                        description TEXT,
                        agenda_id CHAR(36),
                        max_guests INT,
                        start_date TIMESTAMP,
                        end_date TIMESTAMP,
                        location_id CHAR(36),
                        vendor_id CHAR(36),
                        contact_id CHAR(36),
                        notification_type VARCHAR(100),
                        unique_url VARCHAR(255) UNIQUE,
                        cover_image_url VARCHAR(500),
                        timezone VARCHAR(100),
                        status VARCHAR(50) DEFAULT 'draft', -- draft, published, cancelled, completed
                        visibility VARCHAR(50) DEFAULT 'private', -- private, public, invite_only
                        package_ids JSON,
                        created_by CHAR(36),
                        last_updated_by CHAR(36),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        CONSTRAINT fk_event_type FOREIGN KEY (event_type_id) REFERENCES event_types(id),
                        CONSTRAINT fk_event_info FOREIGN KEY (event_info_id) REFERENCES event_info(id)
);

-- ===================================
-- 3️⃣ Dietary
-- ===================================
CREATE TABLE dietary (
                         id CHAR(36) PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ===================================
-- 4️⃣ Guests
-- ===================================
CREATE TABLE guests (
                        id CHAR(36) PRIMARY KEY,
                        event_id CHAR(36) NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255),
                        phone_number VARCHAR(50),
                        note TEXT,
                        table_number VARCHAR(50),
                        dietary_preferences JSON,
                        contact_id CHAR(36),
                        notification_type VARCHAR(50),
                        invite_status VARCHAR(50) DEFAULT 'pending', -- pending, invited, confirmed, declined
                        num_of_guests INT DEFAULT 1,
                        rsvp_date TIMESTAMP,
                        is_vip BOOLEAN DEFAULT FALSE,
                        check_in_status BOOLEAN DEFAULT FALSE,
                        qr_code VARCHAR(255),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        CONSTRAINT fk_guest_event FOREIGN KEY (event_id) REFERENCES events(id)
);

-- ===================================
-- 5️⃣ Forms / Fields / Responses
-- ===================================
CREATE TABLE forms (
                       id CHAR(36) PRIMARY KEY,
                       event_id CHAR(36),
                       name VARCHAR(255),
                       description TEXT,
                       version INT DEFAULT 1,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       CONSTRAINT fk_form_event FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE fields (
                        id CHAR(36) PRIMARY KEY,
                        form_id CHAR(36),
                        question VARCHAR(255),
                        field_type VARCHAR(50),
                        field_placeholder VARCHAR(255),
                        validation_rules JSON,
                        options JSON,
                        is_required BOOLEAN DEFAULT TRUE,
                        field_order INT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_field_form FOREIGN KEY (form_id) REFERENCES forms(id)
);

CREATE TABLE responses (
                           id CHAR(36) PRIMARY KEY,
                           field_id CHAR(36),
                           guest_id CHAR(36),
                           event_id CHAR(36),
                           answer TEXT,
                           response_status VARCHAR(50) DEFAULT 'submitted', -- partial/submitted
                           submitted_by_ip VARCHAR(50),
                           submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT fk_response_field FOREIGN KEY (field_id) REFERENCES fields(id),
                           CONSTRAINT fk_response_guest FOREIGN KEY (guest_id) REFERENCES guests(id),
                           CONSTRAINT fk_response_event FOREIGN KEY (event_id) REFERENCES events(id)
);

-- ===================================
-- 6️⃣ Locations
-- ===================================
CREATE TABLE locations (
                           id CHAR(36) PRIMARY KEY,
                           name VARCHAR(255),
                           type VARCHAR(100), -- venue, church, hotel, etc.
                           address_line VARCHAR(255),
                           postal_code VARCHAR(50),
                           city VARCHAR(100),
                           country VARCHAR(100),
                           latitude DECIMAL(10,8),
                           longitude DECIMAL(11,8),
                           google_maps_url VARCHAR(500),
                           description TEXT,
                           photo_url VARCHAR(500),
                           capacity INT,
                           opening_hours JSON,
                           notes TEXT,
                           contact_id CHAR(36),
                           is_active BOOLEAN DEFAULT TRUE,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ===================================
-- 7️⃣ Vendors / Packages
-- ===================================
CREATE TABLE vendors (
                         id CHAR(36) PRIMARY KEY,
                         name VARCHAR(255),
                         vendor_type VARCHAR(100),
                         contact_person VARCHAR(255),
                         phone VARCHAR(50),
                         contact_id CHAR(36),
                         website VARCHAR(500),
                         instagram_url VARCHAR(500),
                         service_area VARCHAR(255),
                         availability_status VARCHAR(50) DEFAULT 'available',
                         contract_url VARCHAR(500),
                         rating DECIMAL(3,2),
                         is_active BOOLEAN DEFAULT TRUE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE packages (
                          id CHAR(36) PRIMARY KEY,
                          vendor_id CHAR(36),
                          name VARCHAR(255),
                          description TEXT,
                          price DECIMAL(10,2),
                          price_currency VARCHAR(10) DEFAULT 'EUR',
                          video_url VARCHAR(500),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_package_vendor FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);

-- ===================================
-- 8️⃣ Music
-- ===================================
CREATE TABLE bands (
                       id CHAR(36) PRIMARY KEY,
                       event_id CHAR(36),
                       name VARCHAR(255) NOT NULL,
                       description TEXT,
                       music_type VARCHAR(50),
                       video_url VARCHAR(500),
                       provider_id VARCHAR(255),
                       contact_name VARCHAR(255),
                       contact_email VARCHAR(255),
                       contact_phone VARCHAR(50),
                       price DECIMAL(10,2),
                       rating DECIMAL(3,2),
                       notes TEXT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       CONSTRAINT fk_music_event FOREIGN KEY (event_id) REFERENCES events(id)
);

-- Optional: store individual song names as separate records
CREATE TABLE music_song_list (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 music_id CHAR(36),
                                 song_name VARCHAR(255),
                                 CONSTRAINT fk_music_song FOREIGN KEY (music_id) REFERENCES music(id)
);

-- ===================================
-- 9️⃣ Budget & Expenses
-- ===================================
CREATE TABLE budgets (
                         id CHAR(36) PRIMARY KEY,
                         event_id CHAR(36),
                         name VARCHAR(255),
                         description TEXT,
                         amount DECIMAL(10,2),
                         remain_amount DECIMAL(10,2),
                         currency VARCHAR(10) DEFAULT 'EUR',
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_budget_event FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE expenses (
                          id CHAR(36) PRIMARY KEY,
                          event_id CHAR(36),
                          budget_id CHAR(36),
                          name VARCHAR(255),
                          description TEXT,
                          amount DECIMAL(10,2),
                          due_date DATE,
                          payment_status VARCHAR(50) DEFAULT 'unpaid',
                          payment_method VARCHAR(50),
                          receipt_url VARCHAR(500),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_expense_event FOREIGN KEY (event_id) REFERENCES events(id),
                          CONSTRAINT fk_expense_budget FOREIGN KEY (budget_id) REFERENCES budgets(id)
);

-- ===================================
-- 🔟 Invitations / Templates / Sections
-- ===================================
CREATE TABLE invitation_templates (
                                      id CHAR(36) PRIMARY KEY,
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
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE invitations (
                             id CHAR(36) PRIMARY KEY,
                             event_id CHAR(36),
                             template_id CHAR(36),
                             form_id CHAR(36),
                             custom_sections JSON,
                             unique_url VARCHAR(255) UNIQUE,
                             sent_at TIMESTAMP,
                             view_count INT DEFAULT 0,
                             last_viewed_at TIMESTAMP,
                             rsvp_token VARCHAR(255),
                             is_active BOOLEAN DEFAULT TRUE,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             CONSTRAINT fk_invitation_event FOREIGN KEY (event_id) REFERENCES events(id),
                             CONSTRAINT fk_invitation_template FOREIGN KEY (template_id) REFERENCES invitation_templates(id),
                             CONSTRAINT fk_invitation_form FOREIGN KEY (form_id) REFERENCES forms(id)
);

CREATE TABLE sections (
                          id CHAR(36) PRIMARY KEY,
                          template_id CHAR(36),
                          name VARCHAR(255),
                          section_type VARCHAR(50), -- image, text, map, form, gallery
                          path VARCHAR(500),
                          order_index INT,
                          is_required BOOLEAN DEFAULT TRUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_section_template FOREIGN KEY (template_id) REFERENCES invitation_templates(id)
);

CREATE TABLE feedback (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                          event_id UUID NOT NULL,
                          guest_id UUID,
                          vendor_id UUID,

                          rating INT CHECK (rating BETWEEN 1 AND 5),
                          comment TEXT,
                          media_url VARCHAR(255),

                          is_public BOOLEAN DEFAULT FALSE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT fk_feedback_event FOREIGN KEY (event_id) REFERENCES events (id) ON DELETE CASCADE,
                          CONSTRAINT fk_feedback_guest FOREIGN KEY (guest_id) REFERENCES guests (id) ON DELETE SET NULL,
                          CONSTRAINT fk_feedback_vendor FOREIGN KEY (vendor_id) REFERENCES vendors (id) ON DELETE SET NULL
);

CREATE TABLE forms (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                       event_id UUID NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       description TEXT,
                       version INT DEFAULT 1,

                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

                       CONSTRAINT fk_form_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);