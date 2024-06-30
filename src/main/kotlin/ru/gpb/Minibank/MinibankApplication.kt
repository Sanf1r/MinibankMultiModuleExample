package ru.gpb.Minibank

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import ru.gpb.backend.BackendApplication
import ru.gpb.midserv.MidservApplication
import ru.gpb.zolbot.ZolbotApplication


@SpringBootApplication
class MinibankApplication

fun main(args: Array<String>) {
    SpringApplication.run(
        arrayOf<Class<*>>(
            ZolbotApplication::class.java,
            MidservApplication::class.java,
            BackendApplication::class.java
        ), args
    )
}
