object Versions {
    const val kotlin = "1.6.0"
    const val coroutine = "1.6.0"

    const val androidxAppcompat = "1.4.0"
    const val androidxFragment = "1.2.5"
    const val androidxCoreKtx = "1.7.0"
    const val androidxConstraint = "2.1.1"
    const val androidxRecyclerView = "1.0.0"
    const val androidxSwipeRefresh = "1.1.0"
    const val androidxNavigation = "2.4.2"
    const val androidxLifecycle = "2.4.0"
    const val androidxViewpager = "1.1.0-alpha01"
    const val androidxWorkManager = "2.7.1"
    const val androidxRoom = "2.4.0-beta01"
    const val androidxPaging = "3.0.0-alpha06"
    const val androidxViewPager2 = "1.0.0"
    const val androidxHilt = "1.0.0-alpha03"
    const val hilt = "2.36"

    const val material = "1.5.0-alpha04"
    const val playServicesLocation = "17.0.0"
    const val googleServices = "4.3.3"
    const val firebaseMessaging = "20.2.0"

    const val javaxInject = "1"
    const val dagger = "2.41"
    const val retrofit = "2.9.0"
    const val okHttp = "3.12.6"
    const val jodaTime = "2.10.6"
    const val maskedEditText = "1.0.5"
    const val decoro = "1.5.0"
    const val kotPref = "2.11.0"
    const val glide = "4.11.0"
    const val stickyHeaders = "0.4.3@aar"
    const val fastAdapter = "5.2.2"
    const val mpAndroidChart = "v3.1.0"
    const val compose = "1.1.0-beta04"
    const val composeMaterial = "1.0.0-alpha02"
    const val accompanist = "0.23.1"
    const val koil = "2.1.0"

    const val mockito = "4.0.0"
    const val mockitoKotlin = "2.1.0"
    const val mockitoInline = "2.13.0"
    const val detekt = "1.2.2"
    const val jacoco = "0.8.5"
    const val junit = "4.12"
    const val junitPlatform = "1.7.0"
    const val junitJupiter = "5.7.0"
    const val androidxRunner = "1.4.0"
    const val androidxEspresso = "3.4.0"
    const val androidxCoreTesting = "1.1.3"

    const val gradle = "7.0.3"
}

object Deps {

    const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCoreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraint}"

    object Test {
        const val jUnit = "junit:junit:${Versions.junit}"
        const val androidJUnit = "androidx.test.ext:junit:${Versions.androidxCoreTesting}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"
    }

    object Gradle {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val tools = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val toolsPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val material3 = "androidx.compose.material3:material3:${Versions.composeMaterial}"
        const val materialIconsCore = "androidx.compose.material:material-icons-core:${Versions.compose}"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:${Versions.androidxAppcompat}"
        const val liveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.androidxNavigation}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.androidxLifecycle}"
        const val jUnit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val koil = "io.coil-kt:coil-compose:${Versions.koil}"
    }

    object AndroidView {
        const val koil = "io.coil-kt:coil:${Versions.koil}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
    }

    object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Accompanist {
        const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    }

    object WorkManager {
        const val core = "androidx.work:work-runtime:${Versions.androidxWorkManager}"
        const val ktx = "androidx.work:work-runtime-ktx:${Versions.androidxWorkManager}"
    }
}
