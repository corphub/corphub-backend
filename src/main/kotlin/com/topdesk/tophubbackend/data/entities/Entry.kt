package com.topdesk.tophubbackend.data.entities

import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.Indexed
import javax.persistence.*

@Entity
@Indexed
data class Entry (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    @Field
    val title: String,

    @Column(nullable = false)
    @Field
    val target: String,

    @ManyToMany(mappedBy = "entries")
    val categories: List<Category>? = null
)
