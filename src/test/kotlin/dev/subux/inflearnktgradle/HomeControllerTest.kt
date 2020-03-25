package dev.subux.inflearnktgradle

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@ExtendWith(SpringExtension::class)
@WebMvcTest
internal class HomeControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    @WithMockUser
    fun hello() {
        mockMvc.get("/hello")
                .andDo { print() }
                .andExpect {
                    status { isOk }
                    view { name("hello") }
                }
    }

    @Test
    fun hello_without_user() {
        mockMvc.get("/hello")
                .andDo { print() }
                .andExpect {
                    status { isUnauthorized }
                }
    }

    @Test
    @WithMockUser
    fun my() {
        mockMvc.get("/my")
                .andDo { print() }
                .andExpect {
                    status { isOk }
                    view { name("my") }
                }
    }
}