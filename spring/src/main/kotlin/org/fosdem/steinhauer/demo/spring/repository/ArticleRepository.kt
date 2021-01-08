package org.fosdem.steinhauer.demo.spring.repository

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.domain.query.QArticle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ArticleRepository {

    fun getAllArticle(): List<Article> = QArticle().findList()

}