package org.fosdem.steinhauer.demo.jooby

import io.jooby.Kooby
import io.jooby.json.JacksonModule
import io.jooby.pac4j.Pac4jModule
import io.jooby.runApp
import org.fosdem.steinhauer.demo.jooby.controller.ArticleController
import org.fosdem.steinhauer.demo.jooby.repository.ArticleRepository
import org.fosdem.steinhauer.demo.jooby.repository.FosdemArticleRepository
import org.fosdem.steinhauer.demo.jooby.service.ArticleService
import org.fosdem.steinhauer.demo.jooby.service.FosdemArticleService
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.pac4j.core.context.WebContext
import org.pac4j.core.credentials.UsernamePasswordCredentials
import org.pac4j.core.credentials.authenticator.Authenticator
import org.pac4j.core.exception.CredentialsException
import org.pac4j.core.profile.CommonProfile
import org.pac4j.core.util.Pac4jConstants
import org.pac4j.http.client.direct.DirectBasicAuthClient

@KoinApiExtension
class App : Kooby({

    install(JacksonModule())
    install(Pac4jModule().client {
        DirectBasicAuthClient(FosdemSimpleAuthenticator())
    })
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

class FosdemSimpleAuthenticator: Authenticator<UsernamePasswordCredentials> {
    override fun validate(credentials: UsernamePasswordCredentials?, context: WebContext?) {
        if (credentials == null) {
            throw CredentialsException("No credentials")
        }

        val username = credentials.username
        val password = credentials.password
        if (username == null ||username.isBlank()) {
            throw CredentialsException("Username can't be blank.")
        }
        if (password == null || password.isBlank()) {
            throw CredentialsException("Password can't be blank")
        }

        if (username == "fosdem" && password == "Fosdem.2021!") {
            val profile = CommonProfile()
            profile.id = username
            profile.addAttribute(Pac4jConstants.USERNAME, username)
            credentials.userProfile = profile
        } else {
            throw CredentialsException("Wrong username or password.")
        }
    }

}