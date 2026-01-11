plugins {
  id("aro.java-library")
}

dependencies {
  api(project(":libs:domain"))

  // Later:
  // - JWT / OAuth abstractions
  // - policy engines
  // - redaction helpers
}
