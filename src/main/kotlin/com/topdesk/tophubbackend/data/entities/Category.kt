package com.topdesk.tophubbackend.data.entities

import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.Indexed
import javax.persistence.*

@Entity
@Indexed
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        @Field
        val name: String,

        @JoinTable(
                name = "category_entry_link",
                joinColumns = [JoinColumn(name = "category_id")],
                inverseJoinColumns = [JoinColumn(name = "entry_id")])
        @ManyToMany(fetch=FetchType.EAGER)
        val entries: List<Entry>? = null
)
