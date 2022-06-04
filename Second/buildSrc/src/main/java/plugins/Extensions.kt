package plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
private typealias AndroidBaseExtension = BaseExtension

internal fun Project.configureDefaultPlugins() {
    plugins.apply(Plugins.androidKotlin)
}

internal fun Project.configureBuild() = this.extensions.getByType<AndroidBaseExtension>().run {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    project.tasks.withType(KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

internal fun Project.configureAndroid() = this.extensions.getByType<AndroidBaseExtension>().run {
    compileSdkVersion(Config.compileSdk)
    buildToolsVersion = Config.buildTools
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.defaultVersionCode
        testInstrumentationRunner = Config.testInstrumentationRunner
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("staging") {
            isMinifyEnabled = true
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules-staging.pro"
            )
        }
    }
}

internal fun Project.configureCompose() = this.extensions.getByType<AndroidBaseExtension>().run {
    buildFeatures.compose = true
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}
