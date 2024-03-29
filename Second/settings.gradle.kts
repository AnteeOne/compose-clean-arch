pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
rootProject.name = "Second"
include(":app")
include(":core:domain")
include(":core:data")
include(":core:di")
include(":core:compose-features")
include(":utils:theme")
include(":features:product-list:api")
include(":features:product-list:impl")
include(":features:product-details:api")
include(":features:product-details:impl")
include(":features:product-adding:api")
include(":features:product-adding:impl")
include(":core:navigation")
include(":libs:compose-network-manager")
