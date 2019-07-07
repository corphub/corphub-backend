package com.topdesk.tophubbackend.data.repositories

import com.topdesk.tophubbackend.data.entities.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Int> {
}

interface EntryRepository : CrudRepository<Entry, Int> {
    fun findByCategories(categories : List<Category>) : List<Entry>
}
