plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.playground"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Core Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// OpenAPI and Swagger UI
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

	// Mapstruct & Lombok
	implementation("org.mapstruct:mapstruct:1.6.3")
	implementation("org.projectlombok:lombok:1.18.36")
	annotationProcessor ("org.mapstruct:mapstruct-processor:1.6.3")
	annotationProcessor ("org.projectlombok:lombok:1.18.36")
	annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

	// DB
	implementation("org.liquibase:liquibase-core:4.30.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("org.flywaydb:flyway-database-postgresql")

	// Testing dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
