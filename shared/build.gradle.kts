plugins {
    kotlin("jvm")
    kotlin("kapt")

}
apply(plugin = "io.ebean")

val ebeanVersion = "12.6.5"
val postgresqlVersion = "42.2.18"

dependencies {
    kapt("io.ebean:kotlin-querybean-generator:${ebeanVersion}")

    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("io.ebean:ebean:${ebeanVersion}")
    implementation("io.ebean:ebean-querybean:${ebeanVersion}")
    implementation("org.postgresql:postgresql:${postgresqlVersion}")

}