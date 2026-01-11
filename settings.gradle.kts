rootProject.name = "ARO"

pluginManagement {
  includeBuild("build-logic")
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}

include(
  "libs:domain",
  "libs:contracts",
  "libs:persistence",
  "libs:observability",
  "libs:security",

  "apps:ingestion",
  "apps:deed-bus",
  "apps:risk-engine",
  "apps:api"
)