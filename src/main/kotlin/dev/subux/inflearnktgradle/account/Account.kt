package dev.subux.inflearnktgradle.account

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("accounts")
class Account(
    var username: String,
    var email: String,
    @Id var id: String? = null
)