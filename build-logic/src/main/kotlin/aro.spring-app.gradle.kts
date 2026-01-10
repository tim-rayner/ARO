plugins {
  id("aro.java-library")
  id("org.springframework.boot")
  id("io.spring.dependency-management")
}

// Disable bootJar until there's actual source code with a main class
tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
  isEnabled = false
}

// Enable standard jar as the default artifact
tasks.named<Jar>("jar") {
  isEnabled = true
}