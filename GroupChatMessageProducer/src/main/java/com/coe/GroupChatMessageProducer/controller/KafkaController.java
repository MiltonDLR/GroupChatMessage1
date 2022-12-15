package com.coe.GroupChatMessageProducer.controller;

import com.coe.GroupChatMessageProducer.model.GroupChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("group-chat-message/produce")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, GroupChatMessage> kafkaEntityTemplate;

    @Autowired
    private KafkaTemplate<String, Integer> kafkaIdGroupChatMessageTemplate;

    @PostMapping("")
    public String saveGroupChatMessage(@RequestBody GroupChatMessage groupChatMessage){
        kafkaEntityTemplate.send("group-chat-message-save-topic", groupChatMessage);
        return "Group Chat Message saved successfully";
    }

    @DeleteMapping("/{idGroupChatMessage}")
    public String deleteGroupChatMessage(@PathVariable("idGroupChatMessage") int idGroupChatMessage){
        kafkaIdGroupChatMessageTemplate.send("group-chat-message-delete-topic", idGroupChatMessage);
        return "Group chat message deleted successfully";
    }
}
