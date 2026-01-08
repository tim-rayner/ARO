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
  versionCatalogs {
    create("libs") {
      from(files("gradle/libs.versions.toml"))
    }
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