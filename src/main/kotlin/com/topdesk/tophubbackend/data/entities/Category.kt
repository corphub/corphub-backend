package com.topdesk.tophubbackend.data.entities

import javax.persistence.*

@Entity
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val name: String,

        @JoinTable(
                name = "category_entry_link",
                joinColumns = [JoinColumn(name = "category_id")],
                inverseJoinColumns = [JoinColumn(name = "entry_id")])
        @ManyToMany(fetch=FetchType.EAGER)
        val entries: List<Entry>? = null
)
