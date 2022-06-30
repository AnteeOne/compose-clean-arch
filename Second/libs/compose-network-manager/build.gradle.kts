plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.compose)
    id(Plugins.kotlinKapt)
}

dependencies {
    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.material3)
    implementation(Deps.Coroutines.core)
    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.gson)

    implementation(Deps.WorkManager.core)
    implementation(Deps.WorkManager.ktx)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
