package dev.subux.inflearnktgradle

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import javax.sql.DataSource

@SpringBootApplication
class InflearnktgradleApplication

fun main(args: Array<String>) {
    runApplication<InflearnktgradleApplication>(*args)
}


