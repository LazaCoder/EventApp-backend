package com.event.app.models

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "messages")
class Message(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val messageId: Long? = null,
    val senderId: Long,
    val messageText: String,
    val timestamp: LocalDateTime,
    val senderName: String
)
