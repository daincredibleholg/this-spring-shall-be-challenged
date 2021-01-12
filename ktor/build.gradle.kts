plugins {
    kotlin("jvm")
    application
}

version = "1.0"
group = "org.fosdem.steinhauer.demo.ktor"

val ktorVersion = "1.5.0"
val logbackVersion = "1.2.1"
val koinVersion = "2.2.2"
val ebeanVersion = "12.6.5"

dependencies {
    api(project(":shared"))
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("io.ktor:ktor-auth:$ktorVersion")


    implementation("org.koin:koin-ktor:$koinVersion")
    implementation("io.ebean:ebean-querybean:${ebeanVersion}")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}
