package tech.antee.second.product_details.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.second.compose_features.Feature
import tech.antee.second.di.keys.FeatureKey
import tech.antee.second.product_details.ProductDetailsFeature
import tech.antee.second.product_details.impl.ProductDetailsFeatureImpl
import javax.inject.Singleton

@Module
interface ProductDetailsFeatureModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureKey(ProductDetailsFeature::class)
    fun productDetailsFeature(feature: ProductDetailsFeatureImpl): Feature
}
