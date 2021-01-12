plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.allopen") version "1.4.21-2"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.2.0"
}

version = "1.0"
group = "org.fosdem.steinhauer.demo.micronaut"

micronaut {
    runtime("netty")
//    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("org.fosdem.steinhauer.demo.micronaut.*")
    }
}

val micronautVersion = properties["micronautVersion"]
val ebeanVersion = "12.6.5"

dependencies {
    kapt (platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt ("io.micronaut:micronaut-validation")
    kapt ("io.micronaut.configuration:micronaut-openapi")
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut.security:micronaut-security-annotations")

    api(project(":shared"))
    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut.security:micronaut-security")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.ebean:ebean-querybean:${ebeanVersion}")
}


application {
    mainClass.set("org.fosdem.steinhauer.demo.micronaut.ApplicationKt")
}