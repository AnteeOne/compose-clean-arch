plugins {
    id(Plugins.androidApplication)
    id(Plugins.androidBase)
    id(Plugins.compose)
    id(Plugins.kotlinKapt)
}

android {
    defaultConfig {
        applicationId = AppConfig.applicationId
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }
}

dependencies {
    projectImplementation(Modules.utilsTheme)
    projectImplementation(Modules.coreDomain)
    projectImplementation(Modules.coreData)
    projectImplementation(Modules.coreDi)
    projectImplementation(Modules.coreComposeFeatures)
    projectImplementation(Modules.coreNavigation)

    projectImplementation(Modules.featureProductListImpl)
    projectImplementation(Modules.featureProductDetailsImpl)
    projectImplementation(Modules.featureProductAddingImpl)

    projectImplementation(Modules.libComposeNetworkManager)

    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.material3)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.toolsPreview)
    implementation(Deps.Compose.navigation)
    debugImplementation(Deps.Compose.tools)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.material)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)

    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.gson)

    implementation(Deps.WorkManager.core)
    implementation(Deps.WorkManager.ktx)
}
