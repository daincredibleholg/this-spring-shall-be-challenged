package org.fosdem.steinhauer.demo.micronaut.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.micronaut.service.ArticleService

@Controller("/article")
class ArticleController(private val articleService: ArticleService) {

    @Get(value ="/", produces = [MediaType.APPLICATION_JSON])
    fun getAllArticle(): List<Article> = articleService.getAllArticle()

}