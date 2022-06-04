buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.Gradle.gradle)
        classpath(Deps.Gradle.kotlinGradle)
    }

    tasks.register<Delete>("clean") {
        delete(rootProject.buildDir)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
