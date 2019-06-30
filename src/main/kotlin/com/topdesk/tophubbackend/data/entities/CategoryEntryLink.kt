package com.topdesk.tophubbackend.data.entities

import javax.persistence.*

@Entity
@Table(name = "category_entry_link")
data class CategoryEntryLink (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val category: Int,

    @Column(nullable = false)
    val entry: Int
)