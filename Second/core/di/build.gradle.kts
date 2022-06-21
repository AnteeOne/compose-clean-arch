plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
    id(Plugins.compose)
}

dependencies {
    projectImplementation(Modules.coreDomain)
    projectImplementation(Modules.coreComposeFeatures)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.gson)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.viewModel)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
