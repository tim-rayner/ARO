plugins {
  id("aro.spring-app")
}

dependencies {
  implementation(project(":libs:domain"))
  implementation(project(":libs:contracts"))
  implementation(project(":libs:observability"))
  implementation(project(":libs:security"))

  // Optional later: Kafka admin client / topic provisioning / schema registry integration
}