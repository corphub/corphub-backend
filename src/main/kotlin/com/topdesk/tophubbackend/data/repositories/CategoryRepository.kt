package com.topdesk.tophubbackend.data.repositories

import com.topdesk.tophubbackend.data.entities.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

//@Transactional
interface CategoryRepository : CrudRepository<Category, Int> {
}