import org.springframework.boot.gradle.tasks.bundling.BootJar
plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.spring") version "1.4.21-2"

    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "org.fosdem.steinhauer.demo.spring"
version = "1.0.0"
val ebeanVersion = "12.6.5"

dependencies {
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    api(project(":shared"))
    api("io.ebean:ebean-querybean:${ebeanVersion}")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

}

tasks.getByName<BootJar>("bootJar") {
    archiveBaseName.set("app")
    archiveClassifier.set("all")
}
