package com.coe.GroupChatMessageProducer.controller;

import com.coe.GroupChatMessageProducer.model.GroupChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group_chat_message/produce")
public class KafkaController {

    private final KafkaTemplate<String, GroupChatMessage> kafkaEntityTemplate;

    private final KafkaTemplate<String, Integer> kafkaIdGroupChatMessageTemplate;

    @Autowired
    public KafkaController(KafkaTemplate<String, GroupChatMessage> kafkaEntityTemplate, KafkaTemplate<String, Integer> kafkaIdGroupChatMessageTemplate) {
        this.kafkaEntityTemplate = kafkaEntityTemplate;
        this.kafkaIdGroupChatMessageTemplate = kafkaIdGroupChatMessageTemplate;
    }

    @PostMapping("")
    public String saveGroupChatMessage(@RequestBody GroupChatMessage groupChatMessage){
        kafkaEntityTemplate.send("group-chat-message-save-topic", groupChatMessage);
        return "Group Chat Message saved successfully";
    }

    @PutMapping("")
    public String editGroupChatMessage(@RequestBody GroupChatMessage groupChatMessage) {
        if(groupChatMessage.getId() <= 0)
            return "Group Chat Message Id cannot be null or 0";
        kafkaEntityTemplate.send("group-chat-message-update-topic", groupChatMessage);
        return "GroupChatMessage upload published successfully";
    }

    @DeleteMapping("/{idGroupChatMessage}")
    public String deleteGroupChatMessage(@PathVariable("idGroupChatMessage") int idGroupChatMessage){
        kafkaIdGroupChatMessageTemplate.send("group-chat-message-delete-topic", idGroupChatMessage);
        return "Group Chat Message deleted successfully";
    }

    @PutMapping("/status/{idGroupChatMessage}/{status}")
    public String statusGroupChatMessage(@PathVariable("idGroupChatMessage") int idGroupChatMessage, @PathVariable("status") String status){
        GroupChatMessage aux = new GroupChatMessage();
        aux.setStatus(status.toUpperCase());
        aux.setId(idGroupChatMessage);
        kafkaEntityTemplate.send("group-chat-message-status-topic", aux);
        return "Group Chat Message status published successfully";
    }

}
