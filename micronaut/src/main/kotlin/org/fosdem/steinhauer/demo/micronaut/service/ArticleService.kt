package org.fosdem.steinhauer.demo.micronaut.service

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.micronaut.repository.ArticleRepository
import javax.inject.Singleton

interface ArticleService {
    fun getAllArticle(): List<Article>
}

@Singleton
class FosdemArticleService (private val articleRepository: ArticleRepository): ArticleService {

    override fun getAllArticle() = articleRepository.getAllArticle()

}