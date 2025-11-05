package org.ivyinc.eventplanner.event.service;

import org.ivyinc.eventplanner.common.BaseMapper;
import org.ivyinc.eventplanner.common.BaseServiceImpl;
import org.ivyinc.eventplanner.event.dto.ContactCreateDto;
import org.ivyinc.eventplanner.event.dto.ContactResponseDto;
import org.ivyinc.eventplanner.event.dto.ContactUpdateDto;
import org.ivyinc.eventplanner.event.model.Contact;
import org.ivyinc.eventplanner.event.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends BaseServiceImpl<Contact, ContactCreateDto, ContactUpdateDto, ContactResponseDto, ContactRepository> {

    public ContactService(ContactRepository repository, BaseMapper<Contact, ContactCreateDto, ContactUpdateDto, ContactResponseDto> mapper) {
        super(repository, mapper);
    }
}

