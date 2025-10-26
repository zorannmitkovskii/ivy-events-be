package org.ivyinc.eventplanner.event.model;

import jakarta.persistence.*;
import lombok.*;
import org.ivyinc.eventplanner.common.BaseEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bands")
public class Band extends BaseEntity {

    @Column(name = "event_id")
    private Long eventId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "music_type", length = 50)
    private String musicType; // e.g., Band, DJ, Live, Playlist, etc.

    @Column(name = "video_url", length = 500)
    private String videoUrl; // promotional or demo video link

    @Column(name = "provider_id", length = 255)
    private String providerId; // ID of vendor, or external provider ref

    @ElementCollection
    @CollectionTable(
            name = "music_song_list",
            joinColumns = @JoinColumn(name = "music_id")
    )
    @Column(name = "song_name")
    private List<String> songList; // JSON list of songs or setlist

    @Column(name = "contact_name", length = 255)
    private String contactName;

    @Column(name = "contact_email", length = 255)
    private String contactEmail;

    @Column(name = "contact_phone", length = 50)
    private String contactPhone;

    @Column(name = "price", precision = 10, scale = 2)
    private Double price; // estimated cost for performance

    @Column(name = "rating", precision = 3, scale = 2)
    private Double rating; // optional average rating

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
}
