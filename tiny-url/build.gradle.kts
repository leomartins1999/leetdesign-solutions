val ktorVersion = "2.1.3"

plugins {
    application
    kotlin("jvm") version "1.7.20"
    id("io.ktor.plugin") version "2.1.3"
}

group = "com.github.leomartins1999"
version = "0.0.1"
application {
    mainClass.set("com.github.leomartins1999.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("io.github.crackthecodeabhi:kreds:0.8")
}