package com.topdesk.tophubbackend.data.repositories

import com.topdesk.tophubbackend.data.entities.CategoryEntryLink
import org.springframework.data.repository.CrudRepository

interface CategoryEntryLinkRepository : CrudRepository<CategoryEntryLink, Int> {
}