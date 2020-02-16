package com.topdesk.tophubbackend.data.entities

import com.expediagroup.graphql.spring.operations.Query
import com.topdesk.tophubbackend.data.repositories.CategoryRepository
import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.Indexed
import org.springframework.stereotype.Component
import javax.persistence.*

@Entity
@Indexed
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        @Field
        val name: String,

        @JoinTable(
                name = "category_entry_link",
                joinColumns = [JoinColumn(name = "category_id")],
                inverseJoinColumns = [JoinColumn(name = "entry_id")])
        @ManyToMany(fetch=FetchType.EAGER)
        val entries: List<Entry>? = null
)

@Component
class AllCategoriesQuery(
        private val categoryRepository: CategoryRepository
) : Query {
        fun getAllCategories() = categoryRepository.findAll().toList()
        fun getCategoryById(id: Int) = categoryRepository.findById(id).get()
}
