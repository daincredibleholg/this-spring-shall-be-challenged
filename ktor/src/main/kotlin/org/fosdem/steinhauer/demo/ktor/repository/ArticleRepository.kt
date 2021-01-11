package org.fosdem.steinhauer.demo.ktor.repository

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.domain.query.QArticle

interface ArticleRepository {
    fun getAllArticle(): List<Article>
}

class FosdemArticleRepository: ArticleRepository {
    override fun getAllArticle(): List<Article> {
        return QArticle().findList()
    }

}