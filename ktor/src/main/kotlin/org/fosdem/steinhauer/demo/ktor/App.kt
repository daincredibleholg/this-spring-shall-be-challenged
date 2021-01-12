package org.fosdem.steinhauer.demo.ktor

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*
import org.fosdem.steinhauer.demo.ktor.repository.ArticleRepository
import org.fosdem.steinhauer.demo.ktor.repository.FosdemArticleRepository
import org.fosdem.steinhauer.demo.ktor.service.ArticleService
import org.fosdem.steinhauer.demo.ktor.service.FosdemArticleService
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Koin) {
        modules(articleModule)
    }
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    install(Authentication) {
        basic(name = "fosdemAuth") {
            realm = "Fosdem Basic Auth"
            validate { credentials ->
                if (credentials.name == "fosdem" && credentials.password == "Fosdem.2021!") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }

    val articleService: ArticleService by inject()

    routing {
        authenticate("fosdemAuth") {
            get("/article/") {
                call.respond(articleService.getAlArticle())
            }
        }
    }
}

val articleModule = module {
    single<ArticleService> { FosdemArticleService(get()) }
    single<ArticleRepository> { FosdemArticleRepository() }
}