package ru.gpb.backend

import kotlinx.serialization.Serializable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

class Back {
}

@RestController("backController")
class RegisterController {
    val list: MutableList<Long> = mutableListOf()

    @PostMapping("/v2/users")
    fun receiveUser(@RequestBody user: User): ResponseEntity<Error> {
        try {
            if (list.contains(user.userId)) {
                println("User already registered")
                return ResponseEntity(
                    Error(
                        "Произошло что-то ужасное, но станет лучше, честно",
                        "GeneralError",
                        "409",
                        "5f59e024-03c7-498d-9fc9-b8b15fd49c47"
                    ), HttpStatus.CONFLICT
                )
            } else {
                list.add(user.userId)
                println("User recorded - $user")
                return ResponseEntity.noContent().build()
            }
        } catch (e: Exception) {
            println("Something went wrong")
            return ResponseEntity(
                Error(
                    "Произошло что-то ужасное, но станет лучше, честно",
                    "GeneralError",
                    "500",
                    "5f59e024-03c7-498d-9fc9-b8b15fd49c47"
                ), HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}

@Serializable
data class Error(val message: String, val type: String, val code: String, val traceId: String)

@Serializable
data class User(val userId: Long, val userName: String)