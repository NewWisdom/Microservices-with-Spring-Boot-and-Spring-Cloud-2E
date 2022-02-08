import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.getByName<Jar>("jar") {
    enabled = false
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = true
    mainClassName = "se.magnus.microservices.core.recommendation.RecommendationServiceApplicationKt"
    archiveFileName.set("${archiveBaseName.get()}.${archiveExtension.get()}")
}

plugins {
    id("org.springframework.boot") version Versions.springboot
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
}

group = "se.magnus.microservices"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":util"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.mapstruct:mapstruct:${Versions.mapstruct}")
    compileOnly("org.mapstruct:mapstruct-processor:${Versions.mapstruct}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${Versions.mapstruct}")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:${Versions.mapstruct}")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    implementation(platform("org.testcontainers:testcontainers-bom:${Versions.testcontainersBom}"))
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mongodb")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("prepareKotlinBuildScriptModel") {}