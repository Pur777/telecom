package com.example.subscriber.service;

import com.example.subscriber.dto.MessageDto;
import com.example.subscriber.mapper.MessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class MessageService {

    private final static Logger log = LoggerFactory.getLogger(MessageService.class);


    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void saveMessage(MessageDto dto) {
        log.info("Save message with id {}",dto.getId());
        entityManager.persist(MessageMapper.mapMessageDtoToMessage(dto));
    }
}
