package com.event.app.controllers

import com.event.app.repository.Event
import com.event.app.repository.EventRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate


@CrossOrigin(origins = ["*"]) // Use more restrictive settings in production
@RestController
@RequestMapping("/events")
class EventController(private val eventRepository: EventRepository) {

    @GetMapping
    fun getAllEvents(): ResponseEntity<List<Event>> = ResponseEntity.ok(eventRepository.findAll())


    // Modify your method signature
    @GetMapping("/date/{date}")
    fun getEventsByDate(@PathVariable date: LocalDate): ResponseEntity<List<Event>> {
        val events = eventRepository.findByEventDate(date)
        println("printam date")
        println(events)
        return if (events.isNullOrEmpty()) {

            println("greska")
            ResponseEntity.noContent().build()
        } else {
            println("dobro je")
            ResponseEntity.ok(events)
        }
    }


@PostMapping
fun createEvent(@RequestBody event: Event): ResponseEntity<Event> {
    val savedEvent = eventRepository.save(event)
    return ResponseEntity(savedEvent, HttpStatus.CREATED)
}

}



