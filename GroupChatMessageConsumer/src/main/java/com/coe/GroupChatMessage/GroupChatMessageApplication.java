package com.coe.GroupChatMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class GroupChatMessageApplication {

	public static void main(String[] args) {

		SpringApplication.run(GroupChatMessageApplication.class, args);
	}

}
