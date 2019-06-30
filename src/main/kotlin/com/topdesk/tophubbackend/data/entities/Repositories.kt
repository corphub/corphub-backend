package com.topdesk.tophubbackend.data.entities

import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Int> {
}