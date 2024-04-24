package com.event.app.controllers

import com.event.app.repository.User
import com.event.app.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.MediaType

@RestController
@RequestMapping("/auth")
class AuthController(private val userRepository: UserRepository) {

    @PostMapping("/login", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        val user = userRepository.findByName(request.name)
        return if (user != null && user.password == request.password) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mapOf("message" to "Invalid username or password"))
        }
    }
}


data class LoginRequest(
    val name: String,
    val password: String
)