plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
}

dependencies {
    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.gson)
}
