package tech.antee.second.di

import dagger.Module
import tech.antee.second.product_adding.impl.di.ProductAddingFeatureModule
import tech.antee.second.product_details.impl.di.ProductDetailsFeatureModule
import tech.antee.second.product_list.impl.di.ProductListFeatureModule

@Module(
    includes = [
        ProductListFeatureModule::class,
        ProductDetailsFeatureModule::class,
        ProductAddingFeatureModule::class
    ]
)
interface NavigationModule
