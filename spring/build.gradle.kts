
plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.spring") version "1.4.21-2"

    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

apply(plugin = "io.ebean")

val ebeanVersion = "12.6.5"
val flywayVersion = "7.2.0"
val postgresqlVersion = "42.2.18"

dependencies {
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    kapt("io.ebean:kotlin-querybean-generator:${ebeanVersion}")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-jdbc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.ebean:ebean:${ebeanVersion}")
    implementation("io.ebean:ebean-querybean:${ebeanVersion}")
    implementation("org.flywaydb:flyway-core:${flywayVersion}")
    implementation("org.postgresql:postgresql:${postgresqlVersion}")
}