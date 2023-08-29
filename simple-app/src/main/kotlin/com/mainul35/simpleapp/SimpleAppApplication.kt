package com.mainul35.simpleapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SimpleAppApplication

fun main(args: Array<String>) {
	runApplication<SimpleAppApplication>(*args)
}


@RestController
@RequestMapping("/")
class SimpleController {

	@GetMapping
	fun sayHello (): ResponseEntity<String> {
		return ResponseEntity.ok("Hello from the other side!")
	}
}