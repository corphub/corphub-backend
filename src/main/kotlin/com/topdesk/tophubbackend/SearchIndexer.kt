package com.topdesk.tophubbackend

import org.hibernate.SessionFactory
import org.hibernate.search.Search
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.EntityManagerFactory


@Component
class SearchIndexer @Autowired
constructor(factory: EntityManagerFactory) {

    private val hibernateFactory: SessionFactory

    init {
        if (factory.unwrap(SessionFactory::class.java) == null) {
            throw NullPointerException("factory is not a hibernate factory.")
        }
        this.hibernateFactory = factory.unwrap(SessionFactory::class.java)
        val session = this.hibernateFactory.openSession()
        val fullTextSession = Search.getFullTextSession(session)
        fullTextSession.createIndexer().startAndWait()
    }

}