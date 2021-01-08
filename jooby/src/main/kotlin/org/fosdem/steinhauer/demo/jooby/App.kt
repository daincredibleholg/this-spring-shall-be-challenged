package org.fosdem.steinhauer.demo.jooby

import io.jooby.Kooby
import io.jooby.json.JacksonModule
import io.jooby.runApp
import org.fosdem.steinhauer.demo.jooby.controller.ArticleController
import org.fosdem.steinhauer.demo.jooby.repository.ArticleRepository
import org.fosdem.steinhauer.demo.jooby.repository.FosdemArticleRepository
import org.fosdem.steinhauer.demo.jooby.service.ArticleService
import org.fosdem.steinhauer.demo.jooby.service.FosdemArticleService
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin
import org.koin.dsl.module

@KoinApiExtension
class App : Kooby({

    install(JacksonModule())
    mvc(ArticleController())

})

@KoinApiExtension
fun main(args: Array<String>) {
    startKoin {
        printLogger()
        modules(articleModule)
    }

    runApp(args, App::class)
}

@Suppress("USELESS_CAST")
@OptIn(KoinApiExtension::class)
val articleModule = module {
    single { FosdemArticleService() as ArticleService }
    single { FosdemArticleRepository() as ArticleRepository }
}