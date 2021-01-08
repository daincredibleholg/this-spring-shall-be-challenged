
plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.spring") version "1.4.21-2"

    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

val ebeanVersion = "12.6.5"

dependencies {
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    api(project(":shared"))
    api("io.ebean:ebean-querybean:${ebeanVersion}")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-jdbc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

}