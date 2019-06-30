package com.topdesk.tophubbackend.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class VersionQueryResolver : GraphQLQueryResolver {
    fun version() = "1.0.0"
}