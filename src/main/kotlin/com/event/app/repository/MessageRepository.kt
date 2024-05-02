package com.event.app.repository

import com.event.app.models.Message
import org.springframework.data.jpa.repository.JpaRepository




interface MessageRepository : JpaRepository<Message, Long>
{

}