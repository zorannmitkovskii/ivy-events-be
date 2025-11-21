package org.ivyinc.eventplanner.event.builder;

import org.ivyinc.eventplanner.common.builder.DtoBuilder;
import org.ivyinc.eventplanner.event.dto.FeedbackCreateDto;
import org.ivyinc.eventplanner.event.dto.FeedbackResponseDto;
import org.ivyinc.eventplanner.event.dto.FeedbackUpdateDto;
import org.ivyinc.eventplanner.event.model.Event;
import org.ivyinc.eventplanner.event.model.Feedback;
import org.ivyinc.eventplanner.event.model.Guest;
import org.ivyinc.eventplanner.event.model.Vendor;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class FeedbackBuilder implements DtoBuilder<
        Feedback,
        FeedbackCreateDto,
        FeedbackUpdateDto,
        FeedbackResponseDto
        > {

    // ==========================================================
    // Shared test data builders (Events, Guests, Vendors)
    // ==========================================================


    protected final EventTypeBuilder.Wedding weddingEventTypeBuilder = new EventTypeBuilder.Wedding();
    protected final EventTypeBuilder.TeamBuilding teamBuildingEventTypeBuilder = new EventTypeBuilder.TeamBuilding();

    protected final EventBuilder.Wedding weddingEventBuilder = new EventBuilder.Wedding();
    protected final EventBuilder.TeamBuilding teamBuildingEventBuilder = new EventBuilder.TeamBuilding();

    protected final Event weddingEvent = weddingEventBuilder.sampleEntity();
    protected final Event teamBuildingEvent = teamBuildingEventBuilder.sampleEntity();

    protected final UUID weddingEventId = weddingEvent.getId();
    protected final UUID teamBuildingEventId = teamBuildingEvent.getId();

    // Guests
    protected final GuestBuilder.WeddingGuest1 weddingGuest1Builder = new GuestBuilder.WeddingGuest1();
    protected final GuestBuilder.WeddingGuest2 weddingGuest2Builder = new GuestBuilder.WeddingGuest2();
    protected final GuestBuilder.TeamBuildingGuest teamGuest1Builder = new GuestBuilder.TeamBuildingGuest();
    protected final GuestBuilder.TeamBuildingGuest teamGuest2Builder = new GuestBuilder.TeamBuildingGuest();

    protected final Guest weddingGuest1 = weddingGuest1Builder.sampleEntity();
    protected final Guest weddingGuest2 = weddingGuest2Builder.sampleEntity();
    protected final Guest teamGuest1 = teamGuest1Builder.sampleEntity();
    protected final Guest teamGuest2 = teamGuest2Builder.sampleEntity();

    // Vendors
    protected final VendorBuilder.Photographer weddingVendorBuilder = new VendorBuilder.Photographer();
    protected final VendorBuilder.Catering teamBuildingVendorBuilder = new VendorBuilder.Catering();

    protected final Vendor weddingVendor = weddingVendorBuilder.sampleEntity();
    protected final Vendor teamBuildingVendor = teamBuildingVendorBuilder.sampleEntity();


    // ==========================================================
    // Abstract overrides
    // ==========================================================

    @Override
    public abstract Feedback sampleEntity();

    @Override
    public abstract FeedbackCreateDto sampleCreateDto();

    @Override
    public abstract FeedbackUpdateDto sampleUpdateDto();

    @Override
    public abstract FeedbackResponseDto sampleCreateResponse(UUID id);

    @Override
    public abstract FeedbackResponseDto sampleUpdateResponse(UUID id);

    @Override
    public Class<FeedbackResponseDto> responseDtoClass() {
        return FeedbackResponseDto.class;
    }


    // ==========================================================
    // 💍 WEDDING FEEDBACK #1
    // ==========================================================
    public static class WeddingFeedback1 extends FeedbackBuilder {

        @Override
        public Feedback sampleEntity() {
            return Feedback.builder()
                    .event(weddingEvent)
                    .guest(weddingGuest1)
                    .vendor(weddingVendor)
                    .rating(5)
                    .comment("Amazing service! Photos look stunning.")
                    .mediaUrl("https://cdn.ivyinc.com/wedding/feedback/photo1.jpg")
                    .isPublic(true)
                    .build();
        }

        @Override
        public FeedbackCreateDto sampleCreateDto() {
            return new FeedbackCreateDto(
                    weddingEventId,
                    weddingGuest1.getId(),
                    weddingVendor.getId(),
                    5,
                    "Amazing service! Photos look stunning.",
                    "https://cdn.ivyinc.com/wedding/feedback/photo1.jpg"
            );
        }

        @Override
        public FeedbackUpdateDto sampleUpdateDto() {
            return new FeedbackUpdateDto(
                    weddingEventId,
                    weddingGuest1.getId(),
                    weddingVendor.getId(),
                    4,
                    "Updated comment: Great service overall.",
                    "https://cdn.ivyinc.com/wedding/feedback/photo1_updated.jpg"
            );
        }

        @Override
        public FeedbackResponseDto sampleCreateResponse(UUID id) {
            return new FeedbackResponseDto(
                    id,
                    5,
                    "Amazing service! Photos look stunning.",
                    "https://cdn.ivyinc.com/wedding/feedback/photo1.jpg",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public FeedbackResponseDto sampleUpdateResponse(UUID id) {
            FeedbackUpdateDto u = sampleUpdateDto();
            return new FeedbackResponseDto(
                    id,
                    u.rating(),
                    u.comment(),
                    u.mediaUrl(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }


    // ==========================================================
    // 💍 WEDDING FEEDBACK #2
    // ==========================================================
    public static class WeddingFeedback2 extends FeedbackBuilder {

        @Override
        public Feedback sampleEntity() {
            return Feedback.builder()
                    .event(weddingEvent)
                    .guest(weddingGuest2)
                    .vendor(weddingVendor)
                    .rating(4)
                    .comment("Good experience but delivery was slightly late.")
                    .mediaUrl(null)
                    .isPublic(false)
                    .build();
        }

        @Override
        public FeedbackCreateDto sampleCreateDto() {
            return new FeedbackCreateDto(
                    weddingEventId,
                    weddingGuest2.getId(),
                    weddingVendor.getId(),
                    4,
                    "Good experience but delivery was slightly late.",
                    null
            );
        }

        @Override
        public FeedbackUpdateDto sampleUpdateDto() {
            return new FeedbackUpdateDto(
                    weddingEventId,
                    weddingGuest2.getId(),
                    weddingVendor.getId(),
                    5,
                    "Updated: everything was perfect!",
                    null
            );
        }

        @Override
        public FeedbackResponseDto sampleCreateResponse(UUID id) {
            return new FeedbackResponseDto(
                    id,
                    4,
                    "Good experience but delivery was slightly late.",
                    null,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public FeedbackResponseDto sampleUpdateResponse(UUID id) {
            FeedbackUpdateDto u = sampleUpdateDto();
            return new FeedbackResponseDto(
                    id,
                    u.rating(),
                    u.comment(),
                    u.mediaUrl(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }


    // ==========================================================
    // 🏢 TEAM BUILDING FEEDBACK #1
    // ==========================================================
    public static class TeamBuildingFeedback1 extends FeedbackBuilder {

        @Override
        public Feedback sampleEntity() {
            return Feedback.builder()
                    .event(teamBuildingEvent)
                    .guest(teamGuest1)
                    .vendor(teamBuildingVendor)
                    .rating(5)
                    .comment("Catering was excellent! Food was fresh and tasty.")
                    .mediaUrl("https://cdn.ivyinc.com/team/feedback/food1.jpg")
                    .isPublic(true)
                    .build();
        }

        @Override
        public FeedbackCreateDto sampleCreateDto() {
            return new FeedbackCreateDto(
                    teamBuildingEventId,
                    teamGuest1.getId(),
                    teamBuildingVendor.getId(),
                    5,
                    "Catering was excellent! Food was fresh and tasty.",
                    "https://cdn.ivyinc.com/team/feedback/food1.jpg"
            );
        }

        @Override
        public FeedbackUpdateDto sampleUpdateDto() {
            return new FeedbackUpdateDto(
                    teamBuildingEventId,
                    teamGuest1.getId(),
                    teamBuildingVendor.getId(),
                    4,
                    "Updated: still good, but portion sizes could be bigger.",
                    null
            );
        }

        @Override
        public FeedbackResponseDto sampleCreateResponse(UUID id) {
            return new FeedbackResponseDto(
                    id,
                    5,
                    "Catering was excellent! Food was fresh and tasty.",
                    "https://cdn.ivyinc.com/team/feedback/food1.jpg",
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public FeedbackResponseDto sampleUpdateResponse(UUID id) {
            FeedbackUpdateDto u = sampleUpdateDto();
            return new FeedbackResponseDto(
                    id,
                    u.rating(),
                    u.comment(),
                    u.mediaUrl(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }


    // ==========================================================
    // 🏢 TEAM BUILDING FEEDBACK #2
    // ==========================================================
    public static class TeamBuildingFeedback2 extends FeedbackBuilder {

        @Override
        public Feedback sampleEntity() {
            return Feedback.builder()
                    .event(teamBuildingEvent)
                    .guest(teamGuest2)
                    .vendor(teamBuildingVendor)
                    .rating(3)
                    .comment("Service was okay, but delivery was late.")
                    .mediaUrl(null)
                    .isPublic(false)
                    .build();
        }

        @Override
        public FeedbackCreateDto sampleCreateDto() {
            return new FeedbackCreateDto(
                    teamBuildingEventId,
                    teamGuest2.getId(),
                    teamBuildingVendor.getId(),
                    3,
                    "Service was okay, but delivery was late.",
                    null
            );
        }

        @Override
        public FeedbackUpdateDto sampleUpdateDto() {
            return new FeedbackUpdateDto(
                    teamBuildingEventId,
                    teamGuest2.getId(),
                    teamBuildingVendor.getId(),
                    4,
                    "Updated: Vendor improved and resolved issues.",
                    null
            );
        }

        @Override
        public FeedbackResponseDto sampleCreateResponse(UUID id) {
            return new FeedbackResponseDto(
                    id,
                    3,
                    "Service was okay, but delivery was late.",
                    null,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }

        @Override
        public FeedbackResponseDto sampleUpdateResponse(UUID id) {
            FeedbackUpdateDto u = sampleUpdateDto();
            return new FeedbackResponseDto(
                    id,
                    u.rating(),
                    u.comment(),
                    u.mediaUrl(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
}
