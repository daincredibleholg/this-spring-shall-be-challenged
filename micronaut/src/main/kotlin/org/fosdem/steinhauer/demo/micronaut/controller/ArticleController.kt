package org.fosdem.steinhauer.demo.micronaut.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.fosdem.steinhauer.demo.domain.Article

@Controller("/article")
class ArticleController {

    @Get(value ="/", produces = [MediaType.APPLICATION_JSON])
    fun getAllArticle(): List<Article> = emptyList()

}