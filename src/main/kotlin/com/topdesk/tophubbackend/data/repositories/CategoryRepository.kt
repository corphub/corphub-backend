package com.topdesk.tophubbackend.data.repositories

import com.topdesk.tophubbackend.data.entities.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Int> {
}