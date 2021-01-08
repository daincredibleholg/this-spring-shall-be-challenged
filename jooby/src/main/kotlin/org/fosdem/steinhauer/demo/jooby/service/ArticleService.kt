package org.fosdem.steinhauer.demo.jooby.service

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.jooby.repository.ArticleRepository
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface ArticleService {
    fun getAllArticles(): List<Article>
}

@KoinApiExtension
class FosdemArticleService: ArticleService, KoinComponent {

    private val articleRepository by inject<ArticleRepository>()

    override fun getAllArticles(): List<Article> = articleRepository.getAllArticles()
}