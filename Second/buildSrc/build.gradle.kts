plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        register("base-gradle-plugin") {
            id = "base-gradle-plugin"
            implementationClass = "plugins.BasePlugin"
        }
        register("base-android-plugin") {
            id = "base-android-plugin"
            implementationClass = "plugins.BaseAndroidPlugin"
        }
        register("compose-plugin") {
            id = "compose-plugin"
            implementationClass = "plugins.ComposePlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
}
