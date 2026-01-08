plugins {
  id("aro.java-library")
}

dependencies {
  api(project(":libs:domain"))

  // Later:
  // - Micrometer
  // - OpenTelemetry
  // - Structured logging
}