import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    val joobyVersion = "2.9.5"

    kotlin("jvm")
    kotlin("kapt")

    id("io.jooby.run") version joobyVersion
    id("com.google.osdetector") version "1.6.2"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("com.github.johnrengelman.shadow") version "6.1.0"

    application
}
apply(plugin = "io.ebean")

application {
    group = "org.fosdem.steinhauer.demo.jooby"
    version = "1.0.0"
    mainClass.set("org.fosdem.steinhauer.demo.jooby.AppKt")
    mainClassName = mainClass.get() //needed by shadowJar
}

val joobyVersion = "2.9.5"
val koinVersion = "2.2.2"
val ebeanVersion = "12.6.5"

configure<DependencyManagementExtension> {
    imports {
        mavenBom("io.jooby:jooby-bom:$joobyVersion")
    }
}

dependencies {
    api(project(":shared"))
    api("io.ebean:ebean-querybean:${ebeanVersion}")

    kapt("io.jooby:jooby-apt")

    implementation("io.jooby:jooby-netty")
    implementation ("io.jooby:jooby-jackson:$joobyVersion")
    implementation("ch.qos.logback:logback-classic")

    implementation("org.koin:koin-core:$koinVersion")

}

kapt {
    arguments {
        arg("jooby.incremental", true)
        arg("jooby.services", true)
        arg("jooby.debug", false)
    }
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("app")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to application.mainClass.get()))
        }
    }

}