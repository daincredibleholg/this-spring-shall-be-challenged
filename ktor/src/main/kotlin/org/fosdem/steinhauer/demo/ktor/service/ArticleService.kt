package org.fosdem.steinhauer.demo.ktor.service

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.ktor.repository.ArticleRepository

interface ArticleService {
    fun getAlArticle(): List<Article>
}

class FosdemArticleService(private val articleRepository: ArticleRepository): ArticleService {
    override fun getAlArticle(): List<Article> {
        return articleRepository.getAllArticle()
    }

}