package org.fosdem.steinhauer.demo.spring.controller

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.spring.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/article")
class ArticleController @Autowired constructor(
    val articleService: ArticleService
) {

    @GetMapping
    fun getAllArticles(): List<Article> {
        return articleService.getAllArticle()
    }

}