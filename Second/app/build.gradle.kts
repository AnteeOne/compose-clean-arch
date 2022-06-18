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
    projectImplementation(Modules.coreComposeFeatures)

    projectImplementation(Modules.featureProductListImpl)
    projectImplementation(Modules.featureProductDetailsImpl)
    projectImplementation(Modules.featureProductAddingImpl)

    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.material3)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.toolsPreview)
    debugImplementation(Deps.Compose.tools)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.material)
    implementation(Deps.Compose.navigation)

    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.gson)
}
