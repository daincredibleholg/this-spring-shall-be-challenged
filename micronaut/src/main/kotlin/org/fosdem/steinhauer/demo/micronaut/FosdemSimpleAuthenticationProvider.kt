package org.fosdem.steinhauer.demo.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import javax.inject.Singleton

@Singleton
class FosdemSimpleAuthenticationProvider : AuthenticationProvider {
    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        return Flowable.create({ emitter ->
            if (authenticationRequest?.identity == "fosdem" && authenticationRequest?.secret == "Fosdem.2021!") {
                emitter.onNext(UserDetails((authenticationRequest.identity as String), emptyList()))
                emitter.onComplete()
            } else {
                emitter.onError(AuthenticationException(AuthenticationFailed()))
            }
        }, BackpressureStrategy.ERROR)
    }
}