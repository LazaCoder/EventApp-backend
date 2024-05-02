package com.event.app.repository

import com.event.app.models.Event
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Repository
interface EventRepository: JpaRepository<Event, Long> {

    fun findByEventName(eventName: String): Event?

    fun findByEventDate(eventDate: LocalDate): List<Event>?

    fun findByEventType(eventType: String): Event?

    fun findByCreatedById(createdById: Long): Event?

    fun findByEventDescription(eventDescription: String): Event?


}