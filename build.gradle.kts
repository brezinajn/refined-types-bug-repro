import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.0"
    application
}

application{
    mainClassName = "TestKt"
}

buildscript {
    repositories {
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
    dependencies {
        classpath("io.arrow-kt:arrow-refined-types-gradle-plugin:1.5.0-SNAPSHOT")
    }
}

apply {
    plugin("io.arrow-kt.refined-types")
}

group = "com.brezinajn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}