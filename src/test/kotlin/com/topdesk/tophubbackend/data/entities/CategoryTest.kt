package com.topdesk.tophubbackend.data.entities

import com.topdesk.tophubbackend.TophubBackendApplication
import com.topdesk.tophubbackend.data.entities.Category
import com.topdesk.tophubbackend.data.entities.CategoryRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [TophubBackendApplication::class])
class HibernateDemoApplicationTests(@Autowired val repo: CategoryRepository) {


    @Test
    fun `basic entity checks`() {
        val category = Category(0, "Test")
        val categorySet = hashSetOf(category)
        repo.save(category)
        assertThat(repo.findAll()).hasSize(1)
        assertThat(categorySet).contains(category)
    }
}