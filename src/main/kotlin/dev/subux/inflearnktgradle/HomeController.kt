package dev.subux.inflearnktgradle

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/hello")
    fun hello(): String = "hello"

    @GetMapping("/my")
    fun my(): String = "my"
}