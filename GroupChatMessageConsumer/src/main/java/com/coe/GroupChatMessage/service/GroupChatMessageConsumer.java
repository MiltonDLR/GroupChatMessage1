package com.coe.GroupChatMessage.service;

import com.coe.GroupChatMessage.entity.GroupChatMessageEntity;
import com.coe.GroupChatMessage.repository.GroupChatMessageRepository;
import com.coe.kafkaproducer.model.GroupChatMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class GroupChatMessageConsumer {
    @Autowired
    private GroupChatMessageRepository groupChatMessageRepository;

    @KafkaListener(topics = "save_group_message", groupId = "group_json")
    public void saveGroupChatMessage(ConsumerRecord<Long, GroupChatMessage> record) throws IOException{
        GroupChatMessage groupChatMessage = record.value();
        groupChatMessage.setCreateDate(new Date());
        GroupChatMessageEntity entity = new GroupChatMessageEntity(groupChatMessage);
        groupChatMessageRepository.save(entity);
    }
}
