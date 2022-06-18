pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
rootProject.name = "Second"
include(":app")
include(":core:data")
include(":utils:theme")
include(":features:product-list:api")
include(":features:product-list:impl")
include(":features:product-details:api")
include(":features:product-details:impl")
include(":features:product-adding:api")
include(":features:product-adding:impl")
include(":core:compose-features")
include(":core:domain")
