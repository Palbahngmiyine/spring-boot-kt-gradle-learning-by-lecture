package dev.subux.inflearnktgradle

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


// 이렇게하면 기본적으로 pgsql로 되어있는 데이터소스를 h2로 가져올 수 있음
@Configuration
class DataSourceConfigurer {

    @Bean
    fun getDataSource(): DataSource? {
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName("org.h2.Driver")
        dataSourceBuilder.url("jdbc:h2:mem:test")
        dataSourceBuilder.username("SA")
        dataSourceBuilder.password("")
        return dataSourceBuilder.build()
    }
}