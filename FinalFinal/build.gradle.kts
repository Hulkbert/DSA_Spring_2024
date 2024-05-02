plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.9.3") // for JVM platform
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}