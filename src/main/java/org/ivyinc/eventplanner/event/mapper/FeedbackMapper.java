package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.FeedbackCreateDto;
import org.ivyinc.eventplanner.event.dto.FeedbackResponseDto;
import org.ivyinc.eventplanner.event.dto.FeedbackUpdateDto;
import org.ivyinc.eventplanner.event.model.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FeedbackMapper extends BaseMapper<Feedback, FeedbackCreateDto, FeedbackUpdateDto, FeedbackResponseDto>{
}