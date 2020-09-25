import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    kotlin("plugin.noarg") version "1.4.10"
    kotlin("plugin.jpa") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
    id("org.springframework.boot") version "2.3.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "br.com.pagseguro"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_14

configurations {
    compile.get().exclude(module = "spring-boot-starter-tomcat")
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

val springfoxVersion = "2.9.2"
val mapStructVersion = "1.4.0.Beta1"
val mysqlConnectorJavaVersion = "8.0.21"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.springfox:springfox-swagger2:$springfoxVersion")
    implementation("io.springfox:springfox-swagger-ui:$springfoxVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("mysql:mysql-connector-java:$mysqlConnectorJavaVersion")
    implementation("org.mapstruct:mapstruct:$mapStructVersion")

    kapt("org.mapstruct:mapstruct-processor:$mapStructVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

kapt {
    correctErrorTypes = true
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
    }
}

noArg {
    annotation("br.com.pagseguro.multiple.card.bootstrap.annotation.NoArgsConstructor")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "14"
    }
}
