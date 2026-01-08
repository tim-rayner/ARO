plugins {
  id("aro.spring-app")
}

dependencies {
  implementation(project(":libs:domain"))
  implementation(project(":libs:contracts"))
  implementation(project(":libs:persistence"))
  implementation(project(":libs:observability"))
  implementation(project(":libs:security"))

  // Later: Spring Web, SSE, auth, rate limiting, etc.
}