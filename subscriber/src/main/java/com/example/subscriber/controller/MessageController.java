package com.example.subscriber.controller;

import com.example.subscriber.dto.MessageDto;
import com.example.subscriber.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveMessage(@RequestBody MessageDto dto) {
        messageService.saveMessage(dto);
    }
}
