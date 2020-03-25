package dev.subux.inflearnktgradle

import dev.subux.inflearnktgradle.account.Account
import dev.subux.inflearnktgradle.account.AccountRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class AccountRepositoryTests {

    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Test
    fun di () {
        // resources 폴더 아래에 schema.sql 파일을 만들어두고 SQL문을 작성하면 시작할때 해당 파일 읽어서 sql 쿼리 질의함
        val account = Account("subin", "pass")
        val newAccount = accountRepository.save(account)
        assertThat(newAccount).isNotNull

        val existingAccount = accountRepository.findByUsername(newAccount.username)
        assertThat(existingAccount).isNotEmpty

        val nonExistingAccount = accountRepository.findByUsername("subux")
        println(nonExistingAccount)
        assertThat(nonExistingAccount).isEmpty
    }
}