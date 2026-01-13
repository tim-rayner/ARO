plugins {
  id("aro.spring-app")
}

dependencies {
  // Internal libraries
  implementation(project(":libs:domain"))
  implementation(project(":libs:contracts"))
  implementation(project(":libs:persistence"))
  implementation(project(":libs:observability"))
  implementation(project(":libs:security"))

  // Spring Boot starters
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.kafka:spring-kafka")

  // Testing
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
