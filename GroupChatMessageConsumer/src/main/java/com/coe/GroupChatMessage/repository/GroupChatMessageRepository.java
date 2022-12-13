package com.coe.GroupChatMessage.repository;

import com.coe.GroupChatMessage.entity.GroupChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupChatMessageRepository extends JpaRepository<GroupChatMessageEntity, Integer> {
}
