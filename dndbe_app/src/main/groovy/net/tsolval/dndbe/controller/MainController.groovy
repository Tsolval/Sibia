package net.tsolval.dndbe.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/')
class MainController {

    @GetMapping
    def showDashboard() {
        'Greetings from Spring Boot!'
    }
}
