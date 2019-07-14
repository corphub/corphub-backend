package com.topdesk.tophubbackend.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.topdesk.tophubbackend.data.repositories.CategoryRepository
import org.springframework.stereotype.Component


@Component
class CategoryQueryResolver(
        private val categoryRepository: CategoryRepository
) : GraphQLQueryResolver {
    fun getCategoryById(id: Int) = categoryRepository.findById(id)
    fun getAllCategories() = categoryRepository.findAll()
}
