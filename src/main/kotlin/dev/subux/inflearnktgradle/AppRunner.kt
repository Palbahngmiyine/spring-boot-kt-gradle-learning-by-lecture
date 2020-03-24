package dev.subux.inflearnktgradle

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class AppRunner : ApplicationRunner {

    @Autowired
    private lateinit var dataSource: DataSource

    override fun run(args: ApplicationArguments?) {
        println(dataSource.connection.metaData.driverName)
    }
}