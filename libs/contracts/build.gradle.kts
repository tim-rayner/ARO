plugins {
  id("aro.java-library")
}

dependencies {
  api(project(":libs:domain"))

  // Later: JSON / Avro / Protobuf / validation annotations
}