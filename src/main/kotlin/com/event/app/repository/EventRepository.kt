package com.event.app.repository

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "Events")
data class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val eventId: Long = 0,

    @Column(name = "created_by_id", nullable = true)
    val createdById: Long,

    @Column(name = "event_name", nullable = true)
    val eventName: String,

    @Column(name = "event_date", nullable = true)
    val eventDate: LocalDate,

    @Column(name = "event_description", length = Int.MAX_VALUE, nullable = true)
    val eventDescription: String,

    @Column(name = "event_type", nullable = true)
    val eventType: String,

    @Column(name= "event_time", nullable = true)
    val eventTime: LocalTime,


)











@Repository
interface EventRepository: JpaRepository<Event, Long> {

    fun findByEventName(eventName: String): Event?

    fun findByEventDate(eventDate: LocalDate): List<Event>?

    fun findByEventType(eventType: String): Event?

    fun findByCreatedById(createdById: Long): Event?

    fun findByEventDescription(eventDescription: String): Event?


}