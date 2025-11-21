package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invitation_templates")
public class InvitationTemplate extends BaseEntity {

    private String name;

    @Column(name = "template_path")
    private String templatePath;

    @Column(name = "preview_image")
    private String previewImage;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column
    private Map<String, Object> sections;

    @Column(name = "theme_color", length = 50)
    private String themeColor;

    @Column(name = "font_style", length = 100)
    private String fontStyle;

    @Column(name = "background_image_url", length = 500)
    private String backgroundImageUrl;

    @Column(name = "language", length = 50)
    private String language;

    @Column(name = "template_version")
    private Integer templateVersion;

    @Column(name = "is_editable")
    private Boolean editable;
}
