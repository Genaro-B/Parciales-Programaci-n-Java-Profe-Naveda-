plugins {
    id("java")
}

group = "usuario"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Driver JDBC para MySQL
    implementation("mysql:mysql-connector-java:8.0.33")

    // (Opcional) Para pruebas con JUnit
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.test {
    useJUnitPlatform()
}



