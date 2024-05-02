package com.event.app.repository

import com.event.app.models.Message
import org.springframework.data.jpa.repository.JpaRepository




interface MessageRepository : JpaRepository<Message, Long>
{
    fun findByMessageId(messageId: Long): Message?
    fun findBySenderId(senderId: Long): Message?
    fun findByMessageText(messageText: String): Message?
    fun findByTimestamp(timestamp: String): Message?
}