plugins {
  id("aro.java-library")
  java
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

