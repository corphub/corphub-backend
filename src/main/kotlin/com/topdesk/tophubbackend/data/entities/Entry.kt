package com.topdesk.tophubbackend.data.entities

import javax.persistence.*

@Entity
data class Entry (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val target: String
)