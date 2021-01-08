package org.fosdem.steinhauer.demo.jooby.controller

import io.jooby.annotations.GET
import io.jooby.annotations.Path
import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.jooby.service.ArticleService
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
@Path("/article/")
class ArticleController: KoinComponent {

    private val articleService by inject<ArticleService>()

    @GET
    fun getAllArticles(): List<Article> {
        return articleService.getAllArticles()
    }
}