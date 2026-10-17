plugins {
    java
    application
    // Đã nâng cấp lên 0.1.0 để không bị lỗi với Gradle đời mới
    id("org.openjfx.javafxplugin") version "0.1.0"

    // Giữ lại jlink để sau này đóng gói app
    id("org.beryx.jlink") version "2.25.0"

    // ĐÃ XÓA: id("org.javamodularity.moduleplugin") để chạy chế độ Classpath bình thường
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.12.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(27)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    // SỬA QUAN TRỌNG: Trỏ chính xác vào class Launcher của bạn
    mainClass.set("org.example.Launcher")
}

javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jlink {
    imageZip.set(layout.buildDirectory.file("/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "app"
    }
}