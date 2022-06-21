plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
    id(Plugins.compose)
}

dependencies {
    projectImplementation(Modules.featureProductListImpl)
    projectImplementation(Modules.featureProductDetailsImpl)
    projectImplementation(Modules.featureProductAddingImpl)
    projectImplementation(Modules.coreComposeFeatures)

    implementation(Deps.appCompat)

    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.navigation)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
