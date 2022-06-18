plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
}

dependencies {
    projectImplementation(Modules.coreDomain)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.gson)
}
