package org.fosdem.steinhauer.demo.micronaut

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("org.fosdem.steinhauer.demo.micronaut.controller")
        .start()
}

