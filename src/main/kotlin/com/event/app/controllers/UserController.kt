package com.event.app.controllers

import com.event.app.repository.User
import com.event.app.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"]) // Use more restrictive settings in production
@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> = ResponseEntity.ok(userRepository.findAll())



    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = userRepository.save(user)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }


}


