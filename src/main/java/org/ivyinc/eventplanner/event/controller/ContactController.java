package org.ivyinc.eventplanner.event.controller;

import lombok.RequiredArgsConstructor;
import org.ivyinc.eventplanner.common.BaseController;
import org.ivyinc.eventplanner.event.dto.ContactCreateDto;
import org.ivyinc.eventplanner.event.dto.ContactResponseDto;
import org.ivyinc.eventplanner.event.dto.ContactUpdateDto;
import org.ivyinc.eventplanner.event.model.Contact;
import org.ivyinc.eventplanner.event.service.ContactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/contacts")
public class ContactController implements BaseController<Contact, ContactCreateDto, ContactUpdateDto, ContactResponseDto> {

    private final ContactService contactService;

    @Override
    public ContactService getService() {
        return contactService;
    }
}
