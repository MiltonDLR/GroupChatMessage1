package com.coe.GroupChatMessageProducer.controller;

import com.coe.GroupChatMessageProducer.model.GroupChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GroupChatMessage")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, GroupChatMessage> kafkaEntityTemplate;

    @Autowired
    private KafkaTemplate<String, Integer> kafkaGroupChatAdminIdTemplate;


//    @GetMapping("/produce/{name}")
//    public String myMessage(@PathVariable("name") final String name){
//        GroupChatMessageDTO groupChatMessageDTO = new GroupChatMessageDTO(); //Crea el objeto del json
//        groupChatMessageDTO.setContent(name);
//        kafkaEntityTemplate.send("GroupChatMessageDTO", groupChatMessageDTO);
//        return "Message Published Successfully";
//    }

    //Instead PathVariable = @RequestBody
    @PostMapping("")
    public String saveGroupMessage(@RequestBody GroupChatMessage groupChatMessage){
        //Si tienes que cambiar algun dato de tu objeto, hacerlo antes del send(enviar)
        kafkaEntityTemplate.send("save_group_message", groupChatMessage);
        return "Group Message published successfully";
    }



}
