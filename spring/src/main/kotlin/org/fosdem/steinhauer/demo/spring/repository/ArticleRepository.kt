package org.fosdem.steinhauer.demo.spring.repository

import org.fosdem.steinhauer.demo.spring.domain.Article
import org.fosdem.steinhauer.demo.spring.domain.query.QArticle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ArticleRepository @Autowired constructor() {

    fun getAllArticle(): List<Article> = QArticle().findList()

}