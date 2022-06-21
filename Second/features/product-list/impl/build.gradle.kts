plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.compose)
    id(Plugins.kotlinKapt)
}

dependencies {
    projectApi(Modules.featureProductListApi)
    projectApi(Modules.featureProductDetailsApi)
    projectApi(Modules.featureProductAddingApi)

    projectImplementation(Modules.utilsTheme)
    projectImplementation(Modules.coreDomain)
    projectImplementation(Modules.coreData)
    projectImplementation(Modules.coreDi)
    projectImplementation(Modules.coreComposeFeatures)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.material)

    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.material3)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.toolsPreview)
    implementation(Deps.Compose.koil)
    implementation(Deps.Compose.navigation)
    debugImplementation(Deps.Compose.tools)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
