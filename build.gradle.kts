plugins {
    id("java")
    id("application")
}

group = "com.miti99"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    compileOnly("org.projectlombok:lombok:1.18.36")

    implementation("org.apache.logging.log4j:log4j-1.2-api:2.24.3")
    implementation("org.apache.logging.log4j:log4j-core:2.24.3")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.24.3")

    implementation("org.telegram:telegrambots-client:8.0.0")
    implementation("org.telegram:telegrambots-longpolling:8.0.0")


    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.miti99.Main")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
    archiveBaseName.set(project.name)
    archiveVersion.set("")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
