package com.example.subscriber.mapper;

import com.example.subscriber.dto.MessageDto;
import com.example.subscriber.model.Message;
import com.example.subscriber.model.Purchase;
import com.example.subscriber.model.Subscription;
import com.example.subscriber.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageMapper {

    private final static Logger log = LoggerFactory.getLogger(MessageService.class);

    public static Message mapMessageDtoToMessage(MessageDto dto) {
        log.info("Mapping dto with id {}", dto.getId());

        if (dto == null) {
            return null;
        }
        switch (dto.getAction()) {
            case PURCHASE:
                return mapMessageDtoToPurchase(dto);
            case SUBSCRIPTION:
                return mapMessageDtoToSubscription(dto);
            default:
                return null;
        }
    }

    private static Message mapMessageDtoToSubscription(MessageDto dto) {
        Subscription subscription = new Subscription();
        subscription.setId(dto.getId());
        subscription.setMsisdn(dto.getMsisdn());
        subscription.setTimestamp(dto.getTimestamp());

        return subscription;
    }

    private static Purchase mapMessageDtoToPurchase(MessageDto dto) {
        Purchase purchase = new Purchase();
        purchase.setId(dto.getId());
        purchase.setMsisdn(dto.getMsisdn());
        purchase.setTimestamp(dto.getTimestamp());

        return purchase;
    }
}
