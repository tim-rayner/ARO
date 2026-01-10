plugins {
  id("aro.java-library")
}

dependencies {
  api(project(":libs:domain"))

  // Later:
  // - JDBC / JPA / R2DBC
  // - Elasticsearch client
  // - Flyway / Liquibase
}

