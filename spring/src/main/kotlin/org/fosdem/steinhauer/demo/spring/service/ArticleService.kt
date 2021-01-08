package org.fosdem.steinhauer.demo.spring.service

import org.fosdem.steinhauer.demo.domain.Article
import org.fosdem.steinhauer.demo.spring.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService @Autowired constructor(val articleRepository: ArticleRepository){

    fun getAllArticle(): List<Article> {
        return articleRepository.getAllArticle()
    }
}