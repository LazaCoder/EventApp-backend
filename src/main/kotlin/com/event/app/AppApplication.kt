package com.event.app

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.event.app.repository")
@EnableAutoConfiguration
class AppApplication
	fun main(args: Array<String>) {
		runApplication<AppApplication>(*args)

		println("Alo")

}