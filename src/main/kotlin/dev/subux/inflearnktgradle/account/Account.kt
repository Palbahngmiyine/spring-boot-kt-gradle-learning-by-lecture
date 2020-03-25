package dev.subux.inflearnktgradle.account

import javax.persistence.*

@Entity
class Account (
        var username: String,
        var password: String,
        var active: Boolean,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
)