package com.coe.GroupChatMessage.controller;

import com.coe.GroupChatMessage.entity.GroupChatMessageEntity;
import com.coe.GroupChatMessage.repository.GroupChatMessageRepository;
import com.coe.kafkaproducer.model.GroupChatMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/group_chat_message")
public class GroupChatMessageController {
    private GroupChatMessageRepository groupChatMessageRepository;

    @GetMapping("/{idGroupMessage}")
        public GroupChatMessage getGroupChatMessageByID(@PathVariable("idGroupMessage") int idGroupMessage){
        if (idGroupMessage <=0)
            return null;

        GroupChatMessageEntity groupChatMessageEntity = groupChatMessageRepository.findById(idGroupMessage).get();
        return new GroupChatMessage(groupChatMessageEntity);
        }

        @GetMapping("")
    public List<GroupChatMessage> getGroupChatMessage(){
        List<GroupChatMessage> groupChatMessages = new ArrayList<>();
        List<GroupChatMessageEntity> entities = groupChatMessageRepository.findAll();
        for (GroupChatMessageEntity entity : entities){
            groupChatMessages.add(new GroupChatMessage(entity));
        }
        return groupChatMessages;
        }
}
