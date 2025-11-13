package org.ivyinc.eventplanner.event.mapper;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.event.dto.PaymentCreateDto;
import org.ivyinc.eventplanner.event.dto.PaymentResponseDto;
import org.ivyinc.eventplanner.event.dto.PaymentUpdateDto;
import org.ivyinc.eventplanner.event.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper extends BaseMapper<Payment, PaymentCreateDto, PaymentUpdateDto, PaymentResponseDto>{
}