import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    kotlin("plugin.noarg") version "1.4.10"
    kotlin("plugin.jpa") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
    id("org.springframework.boot") version "2.4.0-M3"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "br.com.pagseguro"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compile.get().exclude(module = "spring-boot-starter-tomcat")
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

val mapStructVersion = "1.4.0.Beta1"
val mysqlConnectorJavaVersion = "8.0.21"
val springGraalvmNativeVersion = "0.8.2-SNAPSHOT"

dependencies {
    implementation("org.springframework:spring-context-indexer")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.experimental:spring-graalvm-native:$springGraalvmNativeVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
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
        jvmTarget = "11"
    }
}
