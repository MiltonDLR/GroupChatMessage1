package com.coe.GroupChatMessage.service;

import com.coe.GroupChatMessage.entity.GroupChatMessageEntity;
import com.coe.GroupChatMessage.repository.GroupChatMessageRepository;
import com.coe.GroupChatMessage.kafkaproducer.model.GroupChatMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class GroupChatMessageConsumer {
    private final GroupChatMessageRepository groupChatMessageRepository;

    @Autowired
    public GroupChatMessageConsumer(GroupChatMessageRepository groupChatMessageRepository) {
        this.groupChatMessageRepository = groupChatMessageRepository;
    }

    @KafkaListener(topics = "group-chat-message-save-topic", groupId = "group_json")
    public void saveGroupChatMessage(ConsumerRecord<Long, GroupChatMessage> record) throws IOException{
        GroupChatMessage groupChatMessage = record.value();
        groupChatMessage.setCreateDate(new Date());
        GroupChatMessageEntity entity = new GroupChatMessageEntity(groupChatMessage);
        groupChatMessageRepository.save(entity);
    }

    @KafkaListener(topics = "group-chat-message-delete-topic", groupId = "group-json")
    public void deleteGroupChatMessage(ConsumerRecord<Long, GroupChatMessage> record) throws IOException {
        groupChatMessageRepository.deleteById(record.value().getId());
    }
}
