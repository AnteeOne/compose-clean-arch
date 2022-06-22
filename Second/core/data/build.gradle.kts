plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
}

dependencies {
    projectImplementation(Modules.coreDomain)
    projectImplementation(Modules.coreDi)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Coroutines.core)
    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.gson)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
