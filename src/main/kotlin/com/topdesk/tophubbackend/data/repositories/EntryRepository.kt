package com.topdesk.tophubbackend.data.repositories

import com.topdesk.tophubbackend.data.entities.Entry
import org.springframework.data.repository.CrudRepository

interface EntryRepository : CrudRepository<Entry, Int> {
}