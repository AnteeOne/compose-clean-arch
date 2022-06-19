package tech.antee.second.product_adding.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.second.compose_features.Feature
import tech.antee.second.di.keys.FeatureKey
import tech.antee.second.product_adding.ProductAddingFeature
import tech.antee.second.product_adding.impl.ProductAddingFeatureImpl
import javax.inject.Singleton

@Module
interface ProductAddingFeatureModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureKey(ProductAddingFeature::class)
    fun productAddingFeature(feature: ProductAddingFeatureImpl): Feature
}
