package org.fosdem.steinhauer.demo.jooby.repository

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.domain.query.QArticle

interface ArticleRepository {
    fun getAllArticles(): List<Article>
}

class FosdemArticleRepository: ArticleRepository {

    override fun getAllArticles(): List<Article> {
        return QArticle().findList()
    }

}