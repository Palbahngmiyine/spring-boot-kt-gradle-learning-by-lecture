package dev.subux.inflearnktgradle

import dev.subux.inflearnktgradle.account.Account
import dev.subux.inflearnktgradle.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Component

@Component
class RedisRunner : ApplicationRunner {

    @Autowired
    private lateinit var redisTemplate: StringRedisTemplate

    @Autowired
    private lateinit var accountRepository: AccountRepository

    override fun run(args: ApplicationArguments?) {
        val values = redisTemplate.opsForValue()
        values.set("subin", "subux")
        values.set("springboot", "2.2.5")
        values.set("hello", "world")

        val account = Account("subin", "test@mail.com")
        accountRepository.save(account)
        val byId = account.id?.let { accountRepository.findById(it) }
        println(byId!!.get().username)
        println(byId.get().email)
        println(byId.get().id)
    }
}