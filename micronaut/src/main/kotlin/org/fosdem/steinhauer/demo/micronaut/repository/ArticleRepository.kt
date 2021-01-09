package org.fosdem.steinhauer.demo.micronaut.repository

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.domain.query.QArticle
import javax.inject.Singleton

interface ArticleRepository {
    fun getAllArticle(): List<Article>
}

@Singleton
class FosdemArticleRepository: ArticleRepository {

    override fun getAllArticle(): List<Article> {
        return QArticle().findList()
    }
}